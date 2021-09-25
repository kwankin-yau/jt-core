package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_ACK_9207)
public class JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_ACK_9207;

    public JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck() {
        setDataType(DATA_TYPE);
    }

    private byte result;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809Msg_9207_DownExgMsgApplyForMonitorStartupAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
