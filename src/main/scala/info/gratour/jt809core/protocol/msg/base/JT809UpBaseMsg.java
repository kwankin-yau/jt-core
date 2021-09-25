package info.gratour.jt809core.protocol.msg.base;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.BaseMsgs.UP_BASE_MSG_1600)
public class JT809UpBaseMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.BaseMsgs.UP_BASE_MSG_1600;

    public JT809UpBaseMsg() {
        setMsgId(MSG_ID);
    }


    @Override
    public String toString() {
        return "JT809UpBaseMsg{} " + super.toString();
    }
}
