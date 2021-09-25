/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.playback;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_STARTUP_9A01)
public class JT809Msg_9A01_DownPlaybackMsgStartup extends JT809DownPlaybackMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_STARTUP_9A01;

    public static final byte ITEM_TYPE__AV = 0;
    public static final byte ITEM_TYPE__AUDIO = 1;
    public static final byte ITEM_TYPE__VIDEO = 2;
    public static final byte ITEM_TYPE__AUDIO_OR_VIDEO = 3;

    public static final byte STREAM_TYPE__ALL = 0;
    public static final byte STREAM_TYPE__PRIMARY = 1;
    public static final byte STREAM_TYPE__SECONDARY = 2;

    public static final byte MEM_TYPE__ALL = 0;
    public static final byte MEM_TYPE__PRIMARY = 1;
    public static final byte MEM_TYPE__BACKUP = 2;

    public JT809Msg_9A01_DownPlaybackMsgStartup() {
        setDataType(DATA_TYPE);
    }

    private byte channelId;
    private byte avItemType;
    private byte streamType;
    private byte memType;
    private long playbackStartTime;
    private long playbackEndTime;
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

    public byte getStreamType() {
        return streamType;
    }

    public void setStreamType(byte streamType) {
        this.streamType = streamType;
    }

    public byte getMemType() {
        return memType;
    }

    public void setMemType(byte memType) {
        this.memType = memType;
    }

    public long getPlaybackStartTime() {
        return playbackStartTime;
    }

    public void setPlaybackStartTime(long playbackStartTime) {
        this.playbackStartTime = playbackStartTime;
    }

    public long getPlaybackEndTime() {
        return playbackEndTime;
    }

    public void setPlaybackEndTime(long playbackEndTime) {
        this.playbackEndTime = playbackEndTime;
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
}
