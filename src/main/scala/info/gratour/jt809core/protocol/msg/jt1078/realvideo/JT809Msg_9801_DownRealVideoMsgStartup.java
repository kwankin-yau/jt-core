/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.realvideo;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_STARTUP_9801)
public class JT809Msg_9801_DownRealVideoMsgStartup extends JT809DownRealVideoMsg {

    public static final int DATA_TYPE = JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_STARTUP_9801;

    public static final byte CHANNEL_ID__ALL = 0;

    public static final byte ITEM_TYPE__AV = 0;
    public static final byte ITEM_TYPE__AUDIO = 1;
    public static final byte ITEM_TYPE__VIDEO = 2;

    public JT809Msg_9801_DownRealVideoMsgStartup() {
        setDataType(DATA_TYPE);
    }

    private byte channelId;
    private byte avItemType;
    private String authorizeCode;
    private JT809GnssData gnssData;

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

    public String getAuthorizeCode() {
        return authorizeCode;
    }

    public void setAuthorizeCode(String authorizeCode) {
        this.authorizeCode = authorizeCode;
    }

    public JT809GnssData getGnssData() {
        return gnssData;
    }

    public void setGnssData(JT809GnssData gnssData) {
        this.gnssData = gnssData;
    }

    @Override
    public String toString() {
        return "JT809Msg_9801_DownRealVideoMsgStartup{" +
                "channelId=" + channelId +
                ", avItemType=" + avItemType +
                ", authorizeCode='" + authorizeCode + '\'' +
                ", gnssData=" + gnssData +
                "} " + super.toString();
    }
}
