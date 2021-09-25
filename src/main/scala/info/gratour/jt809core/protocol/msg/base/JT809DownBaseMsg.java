package info.gratour.jt809core.protocol.msg.base;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.BaseMsgs.DOWN_BASE_MSG_9600)
public class JT809DownBaseMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.BaseMsgs.DOWN_BASE_MSG_9600;

    public JT809DownBaseMsg() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809DownBaseMsg{} " + super.toString();
    }
}
