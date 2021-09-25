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

import java.util.ArrayList;
import java.util.List;

@JT809DataType(JT809MsgConsts.VideoFileListMsgs.UP_FILELIST_REQ_ACK_1902)
public class JT809Msg_1902_UpFileListReqAck extends JT809UpFileListMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoFileListMsgs.UP_FILELIST_REQ_ACK_1902;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;
    public static final byte RESULT__NOT_SUPPORTED = 2;
    public static final byte RESULT__SESSION_ENDED = 3;
    public static final byte RESULT__INVALID_TOKEN = 4;
    public static final byte RESULT__ILLEGAL_STATE = 5;


    public JT809Msg_1902_UpFileListReqAck() {
        setDataType(DATA_TYPE);
    }

    private byte result;
    private List<JT809_1078AvResItem> itemList;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public List<JT809_1078AvResItem> getItemList() {
        return itemList;
    }

    public void setItemList(List<JT809_1078AvResItem> itemList) {
        this.itemList = itemList;
    }

    public void addItem(JT809_1078AvResItem item) {
        if (itemList == null)
            itemList = new ArrayList<>();

        itemList.add(item);
    }

    @Override
    public String toString() {
        return "JT809Msg_1902_UpFileListReqAck{" +
                "result=" + result +
                ", itemList=" + itemList +
                "} " + super.toString();
    }
}
