/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.filelist;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoFileListMsgs.DOWN_FILELIST_MSG_ACK_9901)
public class JT809Msg_9901_DownFileListMsgAck extends JT809DownFileListMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoFileListMsgs.DOWN_FILELIST_MSG_ACK_9901;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;

    public JT809Msg_9901_DownFileListMsgAck() {
        setDataType(DATA_TYPE);
    }

    private byte result;
    private short itemNumber;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public short getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(short itemNumber) {
        this.itemNumber = itemNumber;
    }

    @Override
    public String toString() {
        return "JT809Msg_9901_DownFileListMsgAck{" +
                "result=" + result +
                ", itemNumber=" + itemNumber +
                "} " + super.toString();
    }
}
