package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_CONNECT_REQ_9001)
public class JT809Msg_9001_DownConnectReq extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_CONNECT_REQ_9001;

    public JT809Msg_9001_DownConnectReq() {
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
        return "JT809Msg_9001_DownConnectReq{" +
                "verifyCode=" + verifyCode +
                "} " + super.toString();
    }
}
