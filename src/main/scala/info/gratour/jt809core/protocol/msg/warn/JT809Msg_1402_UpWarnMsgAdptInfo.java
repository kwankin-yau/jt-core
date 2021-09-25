package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.JT809Utils;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtmodel.alm.AlmRpt;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_ADPT_INFO_1402)
public class JT809Msg_1402_UpWarnMsgAdptInfo extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_ADPT_INFO_1402;

    public JT809Msg_1402_UpWarnMsgAdptInfo() {
        setDataType(DATA_TYPE);
    }

    private byte warnSrc;
    private int warnType;
    private long warnTime;
    private int infoId;
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

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public void assign(AlmRpt almRpt) {
        setVehicleNo(almRpt.getPlateNo());
        setVehicleColor(almRpt.getPlateColor());

        warnSrc = (byte) almRpt.getSrc();
        warnType = almRpt.typValue();
        warnTime = almRpt.getTm();
        infoId = 0;
        infoContent = almRpt.getContent();
    }

    @Override
    public String detailMessage() {
        return "UP_WARN_MSG_ADPT_INFO(1402){" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + JT809Utils.epochSecondsToDateTimeString(warnTime) +
                ", infoId=" + infoId +
                ", infoContent=" + infoContent +
                "}";
    }

    @Override
    public String toString() {
        return "JT809Msg_1402_UpWarnMsgAdptInfo{" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + warnTime +
                ", infoId=" + infoId +
                ", infoContent='" + infoContent + '\'' +
                "} " + super.toString();
    }
}
