package info.gratour.jt809core.protocol.msg.platform;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.PlatformMsgs.DOWN_PLATFORM_MSG_9300)
public class JT809DownPlatformMsg extends JT809PlatformMsg {

    public static final int MSG_ID = JT809MsgConsts.PlatformMsgs.DOWN_PLATFORM_MSG_9300;

    public JT809DownPlatformMsg() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809DownPlatformMsg{} " + super.toString();
    }
}
