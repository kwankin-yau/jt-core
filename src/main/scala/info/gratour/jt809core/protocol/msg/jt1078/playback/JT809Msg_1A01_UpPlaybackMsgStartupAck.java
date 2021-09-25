/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.playback;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoPlaybackMsgs.UP_PLAYBACK_MSG_STARTUP_ACK_1A01)
public class JT809Msg_1A01_UpPlaybackMsgStartupAck extends JT809UpPlaybackMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoPlaybackMsgs.UP_PLAYBACK_MSG_STARTUP_ACK_1A01;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;
    public static final byte RESULT__INVALID_TOKEN = 4;
    public static final byte RESULT__ILLEGAL_STATE = 5;

    public JT809Msg_1A01_UpPlaybackMsgStartupAck() {
        setDataType(DATA_TYPE);
    }

    private String serverIp;
    private int serverPort;
    private byte result;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getServerPort() {
        return serverPort;
    }

    public void setServerPort(int serverPort) {
        this.serverPort = serverPort;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809_1A01_UpPlaybackMsgStartupAck{" +
                "serverIp='" + serverIp + '\'' +
                ", serverPort=" + serverPort +
                ", result=" + result +
                "} " + super.toString();
    }
}
