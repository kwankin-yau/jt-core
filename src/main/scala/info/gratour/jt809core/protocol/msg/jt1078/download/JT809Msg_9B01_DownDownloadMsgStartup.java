/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.download;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoDownloadMsgs.DOWN_DOWNLOAD_MSG_STARTUP_9B01)
public class JT809Msg_9B01_DownDownloadMsgStartup extends JT809DownDownloadMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoDownloadMsgs.DOWN_DOWNLOAD_MSG_STARTUP_9B01;

    public static final byte ITEM_TYPE__AV = 0;
    public static final byte ITEM_TYPE__AUDIO = 1;
    public static final byte ITEM_TYPE__VIDEO = 2;

    public static final byte STREAM_TYPE__PRIMARY = 1;
    public static final byte STREAM_TYPE__SECONDARY = 2;

    public static final byte MEM_TYPE__PRIMARY = 1;
    public static final byte MEM_TYPE__BACKUP = 2;


    public JT809Msg_9B01_DownDownloadMsgStartup() {
        setDataType(DATA_TYPE);
    }

    private byte channelId;
    private long startTime;
    private long endTime;
    private int alarmType808;
    private int alarmType1078;
    private byte avItemType;
    private byte streamType;
    private byte memType;
    private long fileSize;
    private String authorizeCode;
    private JT809GnssData gnssData;

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getAlarmType808() {
        return alarmType808;
    }

    public void setAlarmType808(int alarmType808) {
        this.alarmType808 = alarmType808;
    }

    public int getAlarmType1078() {
        return alarmType1078;
    }

    public void setAlarmType1078(int alarmType1078) {
        this.alarmType1078 = alarmType1078;
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

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
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
        return "JT809_9B01_DownDownloadMsgStartup{" +
                "channelId=" + channelId +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", alarmType808=" + alarmType808 +
                ", alarmType1078=" + alarmType1078 +
                ", avItemType=" + avItemType +
                ", streamType=" + streamType +
                ", memType=" + memType +
                ", fileSize=" + fileSize +
                ", authorizeCode='" + authorizeCode + '\'' +
                ", gnssData=" + gnssData +
                "} " + super.toString();
    }
}
