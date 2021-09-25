package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_LINKTEST_REQ_9005)
public class JT809Msg_9005_DownLinkTestReq extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_LINKTEST_REQ_9005;

    public JT809Msg_9005_DownLinkTestReq() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809Msg_9005_DownLinkTestReq{} " + super.toString();
    }
}
