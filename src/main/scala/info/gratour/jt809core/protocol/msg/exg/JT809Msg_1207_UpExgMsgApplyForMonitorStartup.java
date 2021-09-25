package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_1207)
public class JT809Msg_1207_UpExgMsgApplyForMonitorStartup extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_1207;

    public JT809Msg_1207_UpExgMsgApplyForMonitorStartup() {
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
        return "JT809Msg_1207_UpExgMsgApplyForMonitorStartup{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
