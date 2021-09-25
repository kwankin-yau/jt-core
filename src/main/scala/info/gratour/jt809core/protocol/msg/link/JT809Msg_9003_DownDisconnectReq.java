package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_DISCONNECT_REQ_9003)
public class JT809Msg_9003_DownDisconnectReq extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_DISCONNECT_REQ_9003;

    public JT809Msg_9003_DownDisconnectReq() {
        setMsgId(MSG_ID);
    }

    private int verifyCode;

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "JT809Msg_9003_DownDisconnectReq{" +
                "verifyCode=" + verifyCode +
                "} " + super.toString();
    }
}
