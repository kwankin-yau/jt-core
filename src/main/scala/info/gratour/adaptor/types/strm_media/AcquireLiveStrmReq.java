/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

import info.gratour.gnss.core.strmmediaapi.StrmMediaApi;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_9101_LiveAVReq;

public class AcquireLiveStrmReq implements AcquireStrmReq {

    public static final int PROTO__HTTP_FLV = StrmMediaApi.PROTO__HTTP_FLV();
    public static final int PROTO__RTMP = StrmMediaApi.PROTO__RTMP();

    public static final byte DATA_TYPE__AV = CP_9101_LiveAVReq.DATA_TYPE__AV;
    public static final byte DATA_TYPE__VIDEO = CP_9101_LiveAVReq.DATA_TYPE__VIDEO;
    public static final byte DATA_TYPE__TALK = CP_9101_LiveAVReq.DATA_TYPE__TALK;
    public static final byte DATA_TYPE__LISTEN = CP_9101_LiveAVReq.DATA_TYPE__LISTEN;
    public static final byte DATA_TYPE__BROADCAST = CP_9101_LiveAVReq.DATA_TYPE__BROADCAST;
    public static final byte DATA_TYPE__PASS_THOUGH = CP_9101_LiveAVReq.DATA_TYPE__PASS_THOUGH;

    public static final byte CODE_STREAM__PRIMARY = CP_9101_LiveAVReq.CODE_STREAM__PRIMARY;
    public static final byte CODE_STREAM__SUB = CP_9101_LiveAVReq.CODE_STREAM__SUB;

    public static final int TERM_PROTO__TCP = 0;
    public static final int TERM_PROTO__UDP = 1;


    private String simNo;
    private byte channel;
    private Byte dataType;
    private byte codeStream;
    private int proto;
    private byte connIdx;
    private ServerHint strmServerHint;
    private boolean disableAudio;
    private int termProto;

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

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public byte dataTypeDef() {
        if (dataType == null)
            return 0;
        else
            return dataType;
    }

    public byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(byte codeStream) {
        this.codeStream = codeStream;
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

    public int getTermProto() {
        return termProto;
    }

    public void setTermProto(int termProto) {
        this.termProto = termProto;
    }

    @Override
    public String toString() {
        return "AcquireLiveStrmReq{" +
                "simNo='" + simNo + '\'' +
                ", channel=" + channel +
                ", dataType=" + dataType +
                ", codeStream=" + codeStream +
                ", proto=" + proto +
                ", connIdx=" + connIdx +
                ", strmServerHint=" + strmServerHint +
                ", disableAudio=" + disableAudio +
                ", termProto=" + termProto +
                '}';
    }
}
