/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

import info.gratour.common.types.EpochMillis;
import info.gratour.jtmodel.trk.TrkAddt;

public class CloseAlmReq {

    private long id;
    private EpochMillis tm1;

    private EpochMillis tm0;
    private EpochMillis recvTm0;
    private double lng0;
    private double lat0;
    private float spd0;
    private Float recSpd0;
    private short alt0;
    private short dir0;
    private TrkAddt addt0;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EpochMillis getTm1() {
        return tm1;
    }

    public void setTm1(EpochMillis tm1) {
        this.tm1 = tm1;
    }

    public EpochMillis getTm0() {
        return tm0;
    }

    public void setTm0(EpochMillis tm0) {
        this.tm0 = tm0;
    }

    public EpochMillis getRecvTm0() {
        return recvTm0;
    }

    public void setRecvTm0(EpochMillis recvTm0) {
        this.recvTm0 = recvTm0;
    }

    public double getLng0() {
        return lng0;
    }

    public void setLng0(double lng0) {
        this.lng0 = lng0;
    }

    public double getLat0() {
        return lat0;
    }

    public void setLat0(double lat0) {
        this.lat0 = lat0;
    }

    public float getSpd0() {
        return spd0;
    }

    public void setSpd0(float spd0) {
        this.spd0 = spd0;
    }

    public Float getRecSpd0() {
        return recSpd0;
    }

    public void setRecSpd0(Float recSpd0) {
        this.recSpd0 = recSpd0;
    }

    public short getAlt0() {
        return alt0;
    }

    public void setAlt0(short alt0) {
        this.alt0 = alt0;
    }

    public short getDir0() {
        return dir0;
    }

    public void setDir0(short dir0) {
        this.dir0 = dir0;
    }

    public TrkAddt getAddt0() {
        return addt0;
    }

    public void setAddt0(TrkAddt addt0) {
        this.addt0 = addt0;
    }

    @Override
    public String toString() {
        return "CloseAlmReq{" +
                "id=" + id +
                ", tm1=" + tm1 +
                ", tm0=" + tm0 +
                ", recvTm0=" + recvTm0 +
                ", lng0=" + lng0 +
                ", lat0=" + lat0 +
                ", spd0=" + spd0 +
                ", recSpd0=" + recSpd0 +
                ", alt0=" + alt0 +
                ", dir0=" + dir0 +
                ", addt0=" + addt0 +
                '}';
    }
}
