package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_HISGNSSDATA_ACK_9209)
public class JT809Msg_9209_DownExgMsgApplyHisGnssDataAck extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_APPLY_HISGNSSDATA_ACK_9209;

    public JT809Msg_9209_DownExgMsgApplyHisGnssDataAck() {
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
        return "JT809Msg_9209_DownExgMsgApplyHisGnssDataAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
