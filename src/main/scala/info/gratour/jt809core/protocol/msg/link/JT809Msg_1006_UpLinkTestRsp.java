package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_LINKTEST_RSP_1006)
public class JT809Msg_1006_UpLinkTestRsp extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_LINKTEST_RSP_1006;

    public JT809Msg_1006_UpLinkTestRsp() {
        setMsgId(MSG_ID);
    }

    @Override
    public String toString() {
        return "JT809Msg_1006_UpLinkTestRsp{} " + super.toString();
    }
}
