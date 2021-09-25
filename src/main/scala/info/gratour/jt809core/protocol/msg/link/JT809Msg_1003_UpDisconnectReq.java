package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_DISCONNECT_REQ_1003)
public class JT809Msg_1003_UpDisconnectReq extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_DISCONNECT_REQ_1003;

    public JT809Msg_1003_UpDisconnectReq() {
        setMsgId(MSG_ID);
    }

    private int userId;
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "JT809Msg_1003_UpDisconnectReq{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                "} " + super.toString();
    }
}
