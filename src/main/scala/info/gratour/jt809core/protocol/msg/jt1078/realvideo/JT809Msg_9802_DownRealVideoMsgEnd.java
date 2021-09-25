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

@JT809DataType(JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_END_9802)
public class JT809Msg_9802_DownRealVideoMsgEnd extends JT809DownRealVideoMsg {

    public static final int DATA_TYPE = JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_END_9802;

    public static final byte ITEM_TYPE__AV = 0;
    public static final byte ITEM_TYPE__AUDIO = 1;
    public static final byte ITEM_TYPE__VIDEO = 2;

    public JT809Msg_9802_DownRealVideoMsgEnd() {
        setDataType(DATA_TYPE);
    }

    private byte channelId;
    private byte avItemType;

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public byte getAvItemType() {
        return avItemType;
    }

    public void setAvItemType(byte avItemType) {
        this.avItemType = avItemType;
    }

    @Override
    public String toString() {
        return "JT809Msg_9802_DownRealVideoMsgEnd{" +
                "channelId=" + channelId +
                ", avItemType=" + avItemType +
                "} " + super.toString();
    }
}
