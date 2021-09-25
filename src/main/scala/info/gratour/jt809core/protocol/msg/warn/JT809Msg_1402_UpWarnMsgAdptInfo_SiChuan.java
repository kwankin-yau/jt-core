package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;
import info.gratour.jtmodel.alm.AlmRpt;
import org.apache.commons.codec.binary.Hex;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_ADPT_INFO_1402)
public class JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_ADPT_INFO_1402;

    public JT809Msg_1402_UpWarnMsgAdptInfo_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private byte warnSrc;
    private int warnType;
    private long warnTime;
    private byte[] infoId;
    private String driver;
    private String driverNo;
    private byte level;
    private double lon;
    private double lat;
    private short alt;
    private int vec1;
    private int vec2;
    private byte status;
    private short direction;
    private String infoContent;

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

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
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

    public int getVec1() {
        return vec1;
    }

    public void setVec1(int vec1) {
        this.vec1 = vec1;
    }

    public int getVec2() {
        return vec2;
    }

    public void setVec2(int vec2) {
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

    public byte[] getInfoId() {
        return infoId;
    }

    public void setInfoId(byte[] infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public String infoIdHexString() {
        return Hex.encodeHexString(infoId);
    }

    public void assign(AlmRpt almRpt) {
        setVehicleNo(almRpt.getPlateNo());
        setVehicleColor(almRpt.getPlateColor());
        warnSrc = (byte) almRpt.getSrc();
        warnType = almRpt.typValue();
        warnTime = almRpt.getTm() / 1000L;
        infoId = almRpt.getId().getBytes();
        driver = almRpt.getDrvName();
        driverNo = almRpt.getDrvNo();
        level = (byte) almRpt.getLvl();
        lon = almRpt.getLng();
        lat = almRpt.getLat();
        alt = almRpt.getAlt();
        vec1 = almRpt.getSpd();
        vec2 = almRpt.getRecSpd();
        status = almRpt.getSt();
        direction = almRpt.getDir();
        infoContent = almRpt.getContent();
    }

    @Override
    public String toString() {
        return "JT809Msg_1402_UpWarnMsgAdptInfoSiChuan{" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + warnTime +
                ", infoId=" + JTUtils.cStr(infoId) +
                ", driver='" + driver + '\'' +
                ", driverNo='" + driverNo + '\'' +
                ", level=" + level +
                ", lon=" + lon +
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
