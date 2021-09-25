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

@JT809DataType(JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_STARTUP_ACK_1B01)
public class JT809Msg_1B01_UpDownloadMsgStartupAck extends JT809UpDownloadMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_STARTUP_ACK_1B01;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;
    public static final byte RESULT__INVALID_TOKEN = 4;
    public static final byte RESULT__ILLEGAL_STATE = 5;

    public JT809Msg_1B01_UpDownloadMsgStartupAck() {
        setDataType(DATA_TYPE);
    }

    private byte result;
    private int sessionId;


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

    @Override
    public String toString() {
        return "JT809_1B01_UpDownloadMsgStartupAck{" +
                "result=" + result +
                ", sessionId=" + sessionId +
                "} " + super.toString();
    }
}
