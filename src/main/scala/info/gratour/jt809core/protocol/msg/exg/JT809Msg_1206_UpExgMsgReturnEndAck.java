package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_RETURN_END_ACK_1206)
public class JT809Msg_1206_UpExgMsgReturnEndAck extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_RETURN_END_ACK_1206;

    public JT809Msg_1206_UpExgMsgReturnEndAck() {
        setDataType(DATA_TYPE);
    }

    @Override
    public String toString() {
        return "JT809Msg_1206_UpExgMsgReturnEndAck{} " + super.toString();
    }
}
