package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_CHECK_REQ_9405)
public class JT809Msg_9405_DownWarnMsgCheckReq_SiChuan extends JT809DownWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_CHECK_REQ_9405;

    public JT809Msg_9405_DownWarnMsgCheckReq_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private int warnType;
    private long warnTime;

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

    @Override
    public String toString() {
        return "JT809Msg_9405_DownWarnMsgCheckReq_SiChuan{" +
                "warnType=" + warnType +
                ", warnTime=" + warnTime +
                "} " + super.toString();
    }
}
