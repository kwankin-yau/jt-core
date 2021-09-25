package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_EXG_INFORM_9403)
public class JT809Msg_9403_DownWarnMsgExgInform extends JT809DownWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_EXG_INFORM_9403;

    public JT809Msg_9403_DownWarnMsgExgInform() {
        setDataType(DATA_TYPE);
    }

    private byte warnSrc;
    private int warnType;
    private long warnTime;
    private String warnContent;

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

    public String getWarnContent() {
        return warnContent;
    }

    public void setWarnContent(String warnContent) {
        this.warnContent = warnContent;
    }

    @Override
    public String toString() {
        return "JT809Msg_9403_DownWarnMsgExgInform{" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + warnTime +
                ", warnContent='" + warnContent + '\'' +
                "} " + super.toString();
    }
}
