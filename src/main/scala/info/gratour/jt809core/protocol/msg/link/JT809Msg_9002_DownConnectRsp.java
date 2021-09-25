package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_CONNECT_RSP_9002)
public class JT809Msg_9002_DownConnectRsp extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_CONNECT_RSP_9002;

    public static final int RESULT__OK = 0;
    public static final int RESULT__INVALID_VERIFY_CODE = 1;
    public static final int RESULT__OCCUPIED = 2;
    public static final int RESULT__OTHER_ERROR = 3;

    public JT809Msg_9002_DownConnectRsp() {
        setMsgId(MSG_ID);
    }

    private byte result;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809Msg_9002_DownConnectRsp{" +
                "result=" + result +
                "} " + super.toString();
    }
}
