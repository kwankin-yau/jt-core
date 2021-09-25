package info.gratour.jt809core.protocol;

import io.netty.buffer.ByteBuf;

import java.io.Closeable;

public class JT809Frame implements Closeable {

    private JT809FrameHeader header;
    private ByteBuf body;

    public JT809FrameHeader getHeader() {
        return header;
    }

    public void setHeader(JT809FrameHeader header) {
        this.header = header;
    }

    public ByteBuf getBody() {
        return body;
    }

    public void setBody(ByteBuf body) {
        this.body = body;
    }

    @Override
    public void close() {
        if (body != null) {
            body.release();
            body = null;
        }
    }
}
