package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_CONNECT_RSP_1002)
public class JT809Msg_1002_UpConnectRsp extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_CONNECT_RSP_1002;

    public static final class Result {

    }

    public JT809Msg_1002_UpConnectRsp() {
        setMsgId(MSG_ID);
    }

    public JT809Msg_1002_UpConnectRsp(JT809Msg_1001_UpConnectReq req) {
        this();
        setGnssCenterId(req.getGnssCenterId());
    }

    private byte result;
    private int verifyCode;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public int getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(int verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "JT809Msg_1002_UpConnectRsp{" +
                "result=" + result +
                ", verifyCode=" + verifyCode +
                "} " + super.toString();
    }
}
