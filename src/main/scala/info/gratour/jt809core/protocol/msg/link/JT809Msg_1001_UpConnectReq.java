package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.net.InetSocketAddress;

@JTMsgId(JT809MsgConsts.LinkMsgs.UP_CONNECT_REQ_1001)
public class JT809Msg_1001_UpConnectReq extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.UP_CONNECT_REQ_1001;

    public JT809Msg_1001_UpConnectReq() {
        setMsgId(MSG_ID);
    }

    private int userId;
    private String password;
    private String downLinkIp;
    private int downLinkPort;

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

    public String getDownLinkIp() {
        return downLinkIp;
    }

    public void setDownLinkIp(String downLinkIp) {
        this.downLinkIp = downLinkIp;
    }

    public int getDownLinkPort() {
        return downLinkPort;
    }

    public void setDownLinkPort(int downLinkPort) {
        this.downLinkPort = downLinkPort;
    }

    public InetSocketAddress getDownLinkAddress() {
        return new InetSocketAddress(downLinkIp, downLinkPort);
    }

    @Override
    public String toString() {
        return "JT809Msg_1001_UpConnectReq{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                ", downLinkIp='" + downLinkIp + '\'' +
                ", downLinkPort=" + downLinkPort +
                "} " + super.toString();
    }
}
