/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

import info.gratour.common.types.EpochMillis;
import info.gratour.common.utils.DateTimeUtils;
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_9201_ReplayAVReq;

public class AcquireVodStrmReq2 implements AcquireStrmReq {

    public static final int PROTO__HTTP_FLV = StrmMediaApi.PROTO__HTTP_FLV();
    public static final int PROTO__RTMP = StrmMediaApi.PROTO__RTMP();

    public static final int MEDIA_TYPE__AV = CP_9201_ReplayAVReq.MEDIA_TYPE__AV;
    public static final int MEDIA_TYPE__AUDIO = CP_9201_ReplayAVReq.MEDIA_TYPE__AUDIO;
    public static final int MEDIA_TYPE__VIDEO = CP_9201_ReplayAVReq.MEDIA_TYPE__VIDEO;
    public static final int MEDIA_TYPE__A_OR_V = CP_9201_ReplayAVReq.MEDIA_TYPE__A_OR_V;

    public static final byte CODE_STREAM__ALL = CP_9201_ReplayAVReq.CODE_STREAM__ALL;
    public static final byte CODE_STREAM__PRIMARY = CP_9201_ReplayAVReq.CODE_STREAM__PRIMARY;
    public static final byte CODE_STREAM__SUB = CP_9201_ReplayAVReq.CODE_STREAM__SUB;

    public static final byte STORAGE_TYPE__ALL = CP_9201_ReplayAVReq.STORAGE_TYPE__ALL;
    public static final byte STORAGE_TYPE__PRIMARY = CP_9201_ReplayAVReq.STORAGE_TYPE__PRIMARY;
    public static final byte STORAGE_TYPE__SECONDARY = CP_9201_ReplayAVReq.STORAGE_TYPE__SECONDARY;

    public static final byte MODE__NORMAL = CP_9201_ReplayAVReq.MODE__NORMAL;
    public static final byte MODE__FAST_FORWARD = CP_9201_ReplayAVReq.MODE__FAST_FORWARD;
    public static final byte MODE__KEY_FRAME_BACKWARD = CP_9201_ReplayAVReq.MODE__KEY_FRAME_BACKWARD;
    public static final byte MODE__KEY_FRAME_PLAY = CP_9201_ReplayAVReq.MODE__KEY_FRAME_PLAY;
    public static final byte MODE__UPLOAD_SINGLE_FRAME = CP_9201_ReplayAVReq.MODE__UPLOAD_SINGLE_FRAME;


    private String simNo;
    private byte channel;
    private byte mediaType;
    private byte codeStream;
    private byte storageType;
    private byte mode;
    private byte factor;
    private String startTime;
    private String endTime;
    private int proto;
    private byte connIdx;
    private ServerHint strmServerHint;
    private boolean disableAudio;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    public byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(byte codeStream) {
        this.codeStream = codeStream;
    }

    public byte getStorageType() {
        return storageType;
    }

    public void setStorageType(byte storageType) {
        this.storageType = storageType;
    }

    public byte getMode() {
        return mode;
    }

    public void setMode(byte mode) {
        this.mode = mode;
    }

    public byte getFactor() {
        return factor;
    }

    public void setFactor(byte factor) {
        this.factor = factor;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public EpochMillis startTimeEpoch() {
        if (startTime != null)
            return new EpochMillis(DateTimeUtils.BeijingConv$.MODULE$.stringToMillis(startTime));
        else
            return null;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public EpochMillis endTimeEpoch() {
        if (endTime != null)
            return new EpochMillis(DateTimeUtils.BeijingConv$.MODULE$.stringToMillis(endTime));
        else
            return null;
    }

    public Long endTimeToLong() {
        if (endTime != null)
            return endTimeEpoch().millis();
        else
            return null;
    }

    public int getProto() {
        return proto;
    }

    public void setProto(int proto) {
        this.proto = proto;
    }

    public byte getConnIdx() {
        return connIdx;
    }

    public void setConnIdx(byte connIdx) {
        this.connIdx = connIdx;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    public boolean isDisableAudio() {
        return disableAudio;
    }

    public void setDisableAudio(boolean disableAudio) {
        this.disableAudio = disableAudio;
    }

    @Override
    public String toString() {
        return "AcquireVodStrmReq{" +
                "simNo='" + simNo + '\'' +
                ", channel=" + channel +
                ", mediaType=" + mediaType +
                ", codeStream=" + codeStream +
                ", storageType=" + storageType +
                ", mode=" + mode +
                ", factor=" + factor +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", proto=" + proto +
                ", connIdx=" + connIdx +
                ", strmServerHint=" + strmServerHint +
                ", disableAudio=" + disableAudio +
                '}';
    }
}

