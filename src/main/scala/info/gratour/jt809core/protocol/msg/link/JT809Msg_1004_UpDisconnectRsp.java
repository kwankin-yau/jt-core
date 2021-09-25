package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_DISCONNECT_RSP_1004)
public class JT809Msg_1004_UpDisconnectRsp extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_DISCONNECT_RSP_1004;

    public JT809Msg_1004_UpDisconnectRsp() {
        setMsgId(MSG_ID);
    }
}
