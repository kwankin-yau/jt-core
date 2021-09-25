package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_EMERGENCY_MONITORING_REQ_9505)
public class JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq extends JT809DownCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_EMERGENCY_MONITORING_REQ_9505;

    public JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject paramsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("authenticationCode", authenticationCode);
        o.addProperty("accessPointName", accessPointName);
        o.addProperty("userName", userName);
        o.addProperty("password", password);
        o.addProperty("serverIp", serverIp);
        o.addProperty("tcpPort", tcpPort);
        o.addProperty("udpPort", udpPort);
        o.addProperty("endTime", endTime);
        return o;
    }

    private String authenticationCode;
    private String accessPointName;
    private String userName;
    private String password;
    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private long endTime;

    public String getAuthenticationCode() {
        return authenticationCode;
    }

    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }

    public String getAccessPointName() {
        return accessPointName;
    }

    public void setAccessPointName(String accessPointName) {
        this.accessPointName = accessPointName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "JT809Msg_9505_DownCtrlMsgEmergencyMonitoringReq{" +
                "authenticationCode='" + authenticationCode + '\'' +
                ", accessPointName='" + accessPointName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", serverIp='" + serverIp + '\'' +
                ", tcpPort=" + tcpPort +
                ", udpPort=" + udpPort +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
