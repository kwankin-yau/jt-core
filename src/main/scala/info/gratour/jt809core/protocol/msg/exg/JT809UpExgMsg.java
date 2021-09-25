package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_1200)
public class JT809UpExgMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_1200;

    public JT809UpExgMsg() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809UpExgMsg{} " + super.toString();
    }
}
