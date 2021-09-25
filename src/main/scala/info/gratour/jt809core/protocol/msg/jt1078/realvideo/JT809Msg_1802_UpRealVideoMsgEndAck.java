/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.realvideo;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.RealVideoMsgs.UP_REALVIDEO_MSG_END_ACK_1802)
public class JT809Msg_1802_UpRealVideoMsgEndAck extends JT809UpRealVideoMsg {

    public static final int DATA_TYPE = JT809MsgConsts.RealVideoMsgs.UP_REALVIDEO_MSG_END_ACK_1802;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;

    public JT809Msg_1802_UpRealVideoMsgEndAck() {
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
        return "JT809Msg_1802_UpRealVideoMsgEndAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
