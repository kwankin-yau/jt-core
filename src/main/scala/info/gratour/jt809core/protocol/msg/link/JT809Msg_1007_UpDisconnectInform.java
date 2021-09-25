package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_DISCONNECT_INFORM_1007)
public class JT809Msg_1007_UpDisconnectInform extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_DISCONNECT_INFORM_1007;

    public JT809Msg_1007_UpDisconnectInform() {
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
        return "JT809Msg_1007_UpDisconnectInform{" +
                "errorCode=" + errorCode +
                "} " + super.toString();
    }
}
