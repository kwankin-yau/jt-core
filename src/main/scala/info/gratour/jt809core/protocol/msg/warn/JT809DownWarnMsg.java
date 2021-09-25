package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_9400)
public class JT809DownWarnMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_9400;

    public JT809DownWarnMsg() {
        setMsgId(MSG_ID);
    }


    @Override
    public String toString() {
        return "JT809DownWarnMsg{} " + super.toString();
    }
}
