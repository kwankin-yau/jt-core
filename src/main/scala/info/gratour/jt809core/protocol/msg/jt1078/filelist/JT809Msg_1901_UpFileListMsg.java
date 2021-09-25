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

@JT809DataType(JT809MsgConsts.VideoFileListMsgs.UP_FILELIST_MSG_1901)
public class JT809Msg_1901_UpFileListMsg extends JT809UpFileListMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoFileListMsgs.UP_FILELIST_MSG_1901;

    public JT809Msg_1901_UpFileListMsg() {
        setDataType(DATA_TYPE);
    }

    private List<JT809_1078AvResItem> itemList;

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
        return "JT809_1901_UpFileListMsg{" +
                "itemList=" + itemList +
                "} " + super.toString();
    }
}
