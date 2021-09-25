package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_CHECK_ACK_1405)
public class JT809Msg_1405_UpWarnMsgCheckAck_SiChuan extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_CHECK_ACK_1405;

    public JT809Msg_1405_UpWarnMsgCheckAck_SiChuan() {
        setDataType(DATA_TYPE);
    }


    private byte warnSrc;
    private int warnType;
    private long warnTime;
    private String infoId;
    private String driver;
    private String driverNo;
    private byte level;
    private double lng;
    private double lat;
    private short alt;
    private short vec1;
    private short vec2;
    private byte status;
    private short direction;
    private String infoContent;

    public byte getWarnSrc() {
        return warnSrc;
    }

    public void setWarnSrc(byte warnSrc) {
        this.warnSrc = warnSrc;
    }

    public int getWarnType() {
        return warnType;
    }

    public void setWarnType(int warnType) {
        this.warnType = warnType;
    }

    public long getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(long warnTime) {
        this.warnTime = warnTime;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public byte getLevel() {
        return level;
    }

    public void setLevel(byte level) {
        this.level = level;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public short getAlt() {
        return alt;
    }

    public void setAlt(short alt) {
        this.alt = alt;
    }

    public short getVec1() {
        return vec1;
    }

    public void setVec1(short vec1) {
        this.vec1 = vec1;
    }

    public short getVec2() {
        return vec2;
    }

    public void setVec2(short vec2) {
        this.vec2 = vec2;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    @Override
    public String toString() {
        return "JT809Msg_1405_UpWarnMsgCheckAck_SiChuan{" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + warnTime +
                ", infoId='" + infoId + '\'' +
                ", driver='" + driver + '\'' +
                ", driverNo='" + driverNo + '\'' +
                ", level=" + level +
                ", lng=" + lng +
                ", lat=" + lat +
                ", alt=" + alt +
                ", vec1=" + vec1 +
                ", vec2=" + vec2 +
                ", status=" + status +
                ", direction=" + direction +
                ", infoContent='" + infoContent + '\'' +
                "} " + super.toString();
    }
}
