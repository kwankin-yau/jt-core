/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

import info.gratour.common.types.EpochMillis;

public class VodStrmCtrlReq {

    public static final byte CTRL__PLAY = 0;
    public static final byte CTRL__PAUSE = 1;
    public static final byte CTRL__STOP = 2;
    public static final byte CTRL__FAST_FORWARD = 3;
    public static final byte CTRL__KEY_FRAME_BACKWARD = 4;
    public static final byte CTRL__SEEK = 5;
    public static final byte CTRL__KEY_FRAME_PLAY = 6;

    public static final byte SPEED_FACTOR__IGNORED = 0;
    public static final byte SPEED_FACTOR__1x = 1;
    public static final byte SPEED_FACTOR__2x = 2;
    public static final byte SPEED_FACTOR__4x = 3;
    public static final byte SPEED_FACTOR__8x = 4;
    public static final byte SPEED_FACTOR__16x = 5;



    private String reqId;
    private byte ctrl;
    private Byte factor;
    private EpochMillis time;
    private ServerHint strmServerHint;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    public Byte getFactor() {
        return factor;
    }

    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    public EpochMillis getTime() {
        return time;
    }

    public void setTime(EpochMillis time) {
        this.time = time;
    }

    public Long timeToLong() {
        if (time != null)
            return time.millis();
        else
            return null;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        return "VodStrmCtrlReq{" +
                "reqId='" + reqId + '\'' +
                ", ctrl=" + ctrl +
                ", factor=" + factor +
                ", time=" + time +
                ", strmServerHint=" + strmServerHint +
                '}';
    }
}
