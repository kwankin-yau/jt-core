/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.download;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_END_INFORM_1B02)
public class JT809Msg_1B02_UpDownloadMsgEndInform extends JT809UpDownloadMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_END_INFORM_1B02;

    public JT809Msg_1B02_UpDownloadMsgEndInform() {
        setDataType(DATA_TYPE);
    }

    private byte result;
    private int sessionId;
    private String serverIp;
    private int tcpPort;
    private String userName;
    private String password;
    private String filePath;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "JT809_1B02_UpDownloadMsgEndInform{" +
                "result=" + result +
                ", sessionId=" + sessionId +
                ", serverIp='" + serverIp + '\'' +
                ", tcpPort=" + tcpPort +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", filePath='" + filePath + '\'' +
                "} " + super.toString();
    }
}
