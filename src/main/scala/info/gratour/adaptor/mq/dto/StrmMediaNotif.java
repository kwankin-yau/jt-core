/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class StrmMediaNotif {

    public static final Type TYPE = new TypeToken<StrmMediaNotif>() {
    }.getType();

    public static final String ACT__strmReady = "strmReady";
    public static final String ACT__strmClosed = "strmClosed";
    public static final String ACT__qualityReport = "qr";
    public static final String ACT__seeking = "seeking";
    public static final String ACT__strmPaused = "strmPaused";
    public static final String ACT__strmResumed = "strmResumed";
    public static final String ACT__ctrlGot = "ctrlGot";

    public static final String TYP_liveReq__liveAV = "liveAV";
    public static final String TYP_liveReq__liveV = "liveV";
    public static final String TYP_liveReq__liveA = "liveA";
    public static final String TYP_liveReq__listen = "listen";
    public static final String TYP_liveReq__broadcast = "broadcast";

    public static final String TYP_strmReady__live = "live";
    public static final String TYP_strmReady__replay = "replay";

    public static final String TYP_strmClosed__live = "live";
    public static final String TYP_strmClosed__replay = "replay";

    public static final String TYP_qualityReport_none = "";

    public static final int CLOSE_CAUSE__clientReq = 1;
    public static final int CLOSE_CAUSE__termStrmClose = 2;
    public static final int CLOSE_CAUSE__connectStrmServerFailed = 3;
    public static final int CLOSE_CAUSE__exceptionCaught = 4;
    public static final int CLOSE_CAUSE__keepTimeout = 5;
    public static final int CLOSE_CAUSE__termDataTimeout = 6;


    private String act;
    private String reqId;
    private String typ;
    private String servId;
    private String simNo;
    private short chan;
    private Short codeStream;
    private Byte lostRate;
    private String playUrl;
    private Integer closeCause;
    private String clientData;
    private String closeReason;

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getServId() {
        return servId;
    }

    public void setServId(String servId) {
        this.servId = servId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public short getChan() {
        return chan;
    }

    public void setChan(short chan) {
        this.chan = chan;
    }

    public Short getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(Short codeStream) {
        this.codeStream = codeStream;
    }

    public Byte getLostRate() {
        return lostRate;
    }

    public void setLostRate(Byte lostRate) {
        this.lostRate = lostRate;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public Integer getCloseCause() {
        return closeCause;
    }

    public void setCloseCause(Integer closeCause) {
        this.closeCause = closeCause;
    }

    public String getClientData() {
        return clientData;
    }

    public void setClientData(String clientData) {
        this.clientData = clientData;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    public void updateCloseReason() {
        if (closeCause != null) {
            int cc = closeCause;
            if (cc != 0) {
                switch (cc) {
                    case CLOSE_CAUSE__clientReq:
                        closeReason = "Client request close.";
                        break;

                    case CLOSE_CAUSE__connectStrmServerFailed:
                        closeReason = "Connect stream server failed.";
                        break;

                    case CLOSE_CAUSE__exceptionCaught:
                        closeReason = "Exception caught.";
                        break;

                    case CLOSE_CAUSE__keepTimeout:
                        closeReason = "Client keep timeout.";
                        break;

                    case CLOSE_CAUSE__termDataTimeout:
                        closeReason = "Terminal media data timeout.";
                        break;

                    case CLOSE_CAUSE__termStrmClose:
                        closeReason = "Terminal connection closed.";
                        break;

                    default:
                        closeReason = "unknown";
                        break;
                }
            } else
                closeReason = null;
        } else
            closeReason = null;
    }


    @Override
    public String toString() {
        return "StrmMediaNotif{" +
                "act='" + act + '\'' +
                ", reqId='" + reqId + '\'' +
                ", typ='" + typ + '\'' +
                ", servId='" + servId + '\'' +
                ", simNo='" + simNo + '\'' +
                ", chan=" + chan +
                ", codeStream=" + codeStream +
                ", lostRate=" + lostRate +
                ", playUrl='" + playUrl + '\'' +
                ", closeCause=" + closeCause +
                ", clientData='" + clientData + '\'' +
                ", closeReason='" + closeReason + '\'' +
                '}';
    }
}
