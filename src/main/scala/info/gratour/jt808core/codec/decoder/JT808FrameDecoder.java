package info.gratour.jt808core.codec.decoder;

import info.gratour.common.utils.BcdUtils;
import info.gratour.jt808core.protocol.FrameSplitInfo;
import info.gratour.jt808core.protocol.JT808Frame;
import info.gratour.jt808core.protocol.JT808FrameHeader;
import info.gratour.jtcommon.JTUtils;
import info.gratour.jtcommon.NettyUtils;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class JT808FrameDecoder {

    private static final Logger LOGGER = LoggerFactory.getLogger(JT808FrameDecoder.class);

    private final ByteBufAllocator alloc;
    private ByteBuf workBuf;

    private ParseState parseState = ParseState.START_7E;

    private List<ByteBuf> buffers = new ArrayList<>();

    public JT808FrameDecoder(ByteBufAllocator allocator) {
        alloc = allocator;
        workBuf = alloc.buffer();
    }

    /**
     * Allocate a temporary byte buffer used in {@link JT808FrameDecoder#decodeFrame(ByteBuf, byte[])}
     *
     * @return new allocated temporary byte buffer.
     */
    public static byte[] allocTempBuf() {
        return new byte[128];
    }

    public DecodeState decode(ByteBuf buf) {
        while (buf.readableBytes() > 0) {
            byte b = buf.readByte();
            switch (parseState) {
                case START_7E:
                    if (b == 0x7e) {
                        workBuf.writeByte(b);
                        parseState = ParseState.END_7E;
                    }
                    break;

                case ENCOUNTERED_7D:
                    if (b == 0x01) {
                        workBuf.writeByte(0x7D);
                        parseState = ParseState.END_7E;
                    } else if (b == 0x02) {
                        workBuf.writeByte(0x7E);
                        parseState = ParseState.END_7E;
                    } else {
                        // bad format, discard it
                        parseState = ParseState.START_7E;
                        workBuf.clear();
                    }
                    break;

                case END_7E:
                    if (b == 0x7e) {
                        workBuf.writeByte(b);

                        buffers.add(workBuf);

                        workBuf = alloc.buffer(); // re-allocate new one
                        parseState = ParseState.START_7E;
                    } else if (b == 0x7d) {
                        parseState = ParseState.ENCOUNTERED_7D;
                    } else
                        workBuf.writeByte(b);
                    break;
            }
        }

        if (buffers.size() > 0)
            return DecodeState.DECODED;
        else if (parseState != ParseState.START_7E)
            return DecodeState.RECOGNIZED;
        else
            return DecodeState.UNRECOGNIZED;
    }

    public void getDecoded(List<ByteBuf> decoded) {
        decoded.addAll(buffers);
        buffers.clear();
    }

    public void close() {
        workBuf.release();
    }

    public int calcCrc(ByteBuf buf) {
        int crc = 0;
        int count = buf.readableBytes();
        while (count > 0) {
            crc ^= buf.readByte();
            count--;
        }

        return crc;
    }

    public boolean verifyCrc(ByteBuf wholeFrame) {
        ByteBuf buf = wholeFrame.slice(1, wholeFrame.readableBytes() - 3);
        int crcCalc = calcCrc(buf);
        int crcActual = wholeFrame.getByte(wholeFrame.readableBytes()- 2);

        return crcCalc == crcActual;
    }

    /**
     * Decode a frame object from ByteBuf.
     *
     * @param buf the frame ByteBuffer
     * @param tempBuf a temporary byte buffer used in decode procedure, should allocated by {@link JT808FrameDecoder#allocTempBuf()}
     * @return null if crc verification failed or other format violation
     */
    public JT808Frame decodeFrame(ByteBuf buf, byte[] tempBuf) {
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("BEFORE-decodeFrame: " + NettyUtils.bufToHex(buf));
        }

        if (!verifyCrc(buf)) {
            return null;
        }


        buf.skipBytes(1); // start-tag

        JT808FrameHeader header = new JT808FrameHeader();
        header.setMsgId(buf.readUnsignedShort());
        int attr = buf.readUnsignedShort();
        header.setAttr(attr);
        buf.readBytes(tempBuf, 0, 6);
        String simNo = BcdUtils.decode(tempBuf, 0, 6);
        simNo = JTUtils.normalizeSimNo(simNo);
        header.setSimNo(simNo);
        header.setSeqNo(buf.readUnsignedShort());

        if (JTUtils.bitTest(attr, 13)) {
            FrameSplitInfo splitInfo = new FrameSplitInfo();
            splitInfo.setTotalPacket(buf.readUnsignedShort());
            splitInfo.setPacketSeqNo(buf.readUnsignedShort());
            header.setSplitInfo(splitInfo);
        }


        JT808Frame r = new JT808Frame();
        r.setHeader(header);
        buf.retain();
        r.setBody(buf.slice(buf.readerIndex(), buf.readableBytes()-2)); // exclude crc and end-tag

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Frame decoded (" + r.getClass().getSimpleName() + "):" + r.toString());
        }

        return r;
    }
}
