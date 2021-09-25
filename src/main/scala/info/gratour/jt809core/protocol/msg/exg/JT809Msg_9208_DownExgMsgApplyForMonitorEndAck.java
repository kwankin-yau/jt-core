package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_FOR_MONITOR_END_ACK_9208)
public class JT809Msg_9208_DownExgMsgApplyForMonitorEndAck extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_FOR_MONITOR_END_ACK_9208;

    public JT809Msg_9208_DownExgMsgApplyForMonitorEndAck() {
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
        return "JT809Msg_9208_DownExgMsgApplyForMonitorEndAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
