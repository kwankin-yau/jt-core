package info.gratour.jt809core.protocol;

import info.gratour.common.Consts;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

public class JT809FrameHeader {

    private int msgLength;
    private int msgSn;
    private int msgId;
    private int gnssCenterId;
    private VersionFlag versionFlag;
    private byte encryptFlag;
    private int encryptKey;

    /**
     * epoch seconds
     */
    private long time;

    public int getMsgLength() {
        return msgLength;
    }

    public void setMsgLength(int msgLength) {
        this.msgLength = msgLength;
    }

    public int getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(int msgSn) {
        this.msgSn = msgSn;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getGnssCenterId() {
        return gnssCenterId;
    }

    public void setGnssCenterId(int gnssCenterId) {
        this.gnssCenterId = gnssCenterId;
    }

    public VersionFlag getVersionFlag() {
        return versionFlag;
    }

    public void setVersionFlag(VersionFlag versionFlag) {
        this.versionFlag = versionFlag;
    }

    public byte getEncryptFlag() {
        return encryptFlag;
    }

    public void setEncryptFlag(byte encryptFlag) {
        this.encryptFlag = encryptFlag;
    }

    public int getEncryptKey() {
        return encryptKey;
    }

    public void setEncryptKey(int encryptKey) {
        this.encryptKey = encryptKey;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    private String timeToString() {
        OffsetDateTime odt = OffsetDateTime.ofInstant(Instant.ofEpochSecond(time), Consts.ZONE_ID_Z);
        return odt.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    }

    @Override
    public String toString() {
        return "JT809FrameHeader{" +
                "msgLength=" + msgLength +
                ", msgSn=" + msgSn +
                ", msgId=" + msgId +
                ", gnssCenterId=" + gnssCenterId +
                ", versionFlag=" + versionFlag +
                ", encryptFlag=" + encryptFlag +
                ", encryptKey=" + encryptKey +
                ", time=" + time + "(" + timeToString() + ")" +
                '}';
    }
}
