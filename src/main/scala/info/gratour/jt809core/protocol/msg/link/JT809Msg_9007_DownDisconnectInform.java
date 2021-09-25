package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_DISCONNECT_INFORM_9007)
public class JT809Msg_9007_DownDisconnectInform extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_DISCONNECT_INFORM_9007;

    public JT809Msg_9007_DownDisconnectInform() {
        setMsgId(MSG_ID);
    }

    private byte errorCode;

    public byte getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(byte errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "JT809Msg_9007_DownDisconnectInform{" +
                "errorCode=" + errorCode +
                "} " + super.toString();
    }

}
