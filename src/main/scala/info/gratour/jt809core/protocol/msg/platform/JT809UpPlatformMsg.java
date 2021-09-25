package info.gratour.jt809core.protocol.msg.platform;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.PlatformMsgs.UP_PLATFORM_MSG_1300)
public class JT809UpPlatformMsg extends JT809PlatformMsg {

    public static final int MSG_ID = JT809MsgConsts.PlatformMsgs.UP_PLATFORM_MSG_1300;

    public JT809UpPlatformMsg() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809UpPlatformMsg{} " + super.toString();
    }
}
