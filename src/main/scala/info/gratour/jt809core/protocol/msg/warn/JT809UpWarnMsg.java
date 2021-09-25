package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_1400)
public class JT809UpWarnMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_1400;

    public JT809UpWarnMsg() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809UpWarnMsg{} " + super.toString();
    }
}
