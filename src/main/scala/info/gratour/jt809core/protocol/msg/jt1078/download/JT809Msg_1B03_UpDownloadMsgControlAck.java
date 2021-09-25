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

@JT809DataType(JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_CONTROL_ACK_1B03)
public class JT809Msg_1B03_UpDownloadMsgControlAck extends JT809UpDownloadMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_CONTROL_ACK_1B03;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;

    public JT809Msg_1B03_UpDownloadMsgControlAck() {
        setDataType(DATA_TYPE);
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
        return "JT809_1B03_UpDownloadMsgControlAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
