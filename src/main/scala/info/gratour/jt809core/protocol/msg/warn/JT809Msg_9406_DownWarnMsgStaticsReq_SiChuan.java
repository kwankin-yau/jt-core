package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_STATICS_REQ_9406)
public class JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan extends JT809DownWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_STATICS_REQ_9406;

    public JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "JT809Msg_9406_DownWarnMsgStaticsReq_SiChuan{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
