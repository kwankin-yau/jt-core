package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_FOR_MONTIOR_END_1208)
public class JT809Msg_1208_UpExgMsgApplyForMonitorEnd extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_FOR_MONTIOR_END_1208;

    public JT809Msg_1208_UpExgMsgApplyForMonitorEnd() {
        setDataType(DATA_TYPE);
    }

    @Override
    public String toString() {
        return "JT809Msg_1208_UpExgMsgApplyForMonitorEnd{} " + super.toString();
    }
}
