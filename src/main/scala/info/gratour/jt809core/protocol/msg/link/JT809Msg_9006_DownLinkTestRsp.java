package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_LINKTEST_RSP_9006)
public class JT809Msg_9006_DownLinkTestRsp extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_LINKTEST_RSP_9006;

    public JT809Msg_9006_DownLinkTestRsp() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809Msg_9006_DownLinkTestRsp{} " + super.toString();
    }
}
