package info.gratour.jt809core;


import info.gratour.jtcommon.JTConsts;
import io.netty.buffer.ByteBuf;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class JT809Utils {

    private static final int INIT = 0xFFFF;
    private static final int POLYNOMIAL = 0x1021;

    private static int crcByte(int crc, byte b) {
        for (int i = 0; i < 8; i++) {
            boolean bit = ((b >> (7 - i) & 1) == 1);
            boolean c15 = ((crc >> 15 & 1) == 1);
            crc <<= 1;
            if (c15 ^ bit)
                crc ^= POLYNOMIAL;
        }
        return crc;
    }

    public static int crc(byte[] data) {
        int crc = INIT;
        int polynomial = 0x1021;

        for (byte b : data) {
            crc = crcByte(crc, b);
        }

        crc &= INIT;
        return crc;
    }

    public static int crc(ByteBuf buf) {
        int crc = INIT;


        while (buf.isReadable()) {
            byte b = buf.readByte();
            crc = crcByte(crc, b);
        }

        crc &= INIT;
        return crc;
    }

    public static int crcRetainsReaderIndex(ByteBuf buf) {
        int readerIndex = buf.readerIndex();
        int r = crc(buf);
        buf.readerIndex(readerIndex);

        return r;
    }

    public static void encrypt(int key, int m, int ia, int ic, ByteBuf input, int size, ByteBuf output) {
        int idx = 0;

        if (key == 0)
            key = 1;

        while (idx < size) {
            key = ia * Integer.remainderUnsigned(key, m) + ic;

            byte b = input.readByte();
            int v = key >> 20;
            b ^= v & 0xFF;
            output.writeByte(b);

            idx++;
        }
    }

    public static void decrypt(int key, int m, int ia, int ic, ByteBuf input, int size, ByteBuf output) {
        encrypt(key, m, ia, ic, input, size, output);
    }

    public static String epochSecondsToDateTimeString(long epochSeconds) {
        OffsetDateTime odt = OffsetDateTime.ofInstant(Instant.ofEpochSecond(epochSeconds), JTConsts.ZONE_ID_Z());
        return odt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }
}
