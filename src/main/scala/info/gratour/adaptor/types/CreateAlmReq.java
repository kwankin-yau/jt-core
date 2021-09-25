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

public class CreateAlmReq {

    private long id;
    private String simNo;
    private Long vehId;
    private String plateNo;
    private int plateColor;
    private long trkId;

    private String typ;
    private String subTyp;
    private short src;
    private Short lvl;

    private EpochMillis tm1;
    private EpochMillis recvTm1;
    private double lng1;
    private double lat1;
    private float spd1;
    private Float recSpd1;
    private short alt1;
    private short dir1;
    private TrkAddt addt1;

    private String drvName;
    private String drvNo;

    private String platRgnId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Long getVehId() {
        return vehId;
    }

    public void setVehId(Long vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public long getTrkId() {
        return trkId;
    }

    public void setTrkId(long trkId) {
        this.trkId = trkId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getSubTyp() {
        return subTyp;
    }

    public void setSubTyp(String subTyp) {
        this.subTyp = subTyp;
    }

    public short getSrc() {
        return src;
    }

    public void setSrc(short src) {
        this.src = src;
    }

    public Short getLvl() {
        return lvl;
    }

    public void setLvl(Short lvl) {
        this.lvl = lvl;
    }

    public EpochMillis getTm1() {
        return tm1;
    }

    public void setTm1(EpochMillis tm1) {
        this.tm1 = tm1;
    }

    public EpochMillis getRecvTm1() {
        return recvTm1;
    }

    public void setRecvTm1(EpochMillis recvTm1) {
        this.recvTm1 = recvTm1;
    }

    public double getLng1() {
        return lng1;
    }

    public void setLng1(double lng1) {
        this.lng1 = lng1;
    }

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public float getSpd1() {
        return spd1;
    }

    public void setSpd1(float spd1) {
        this.spd1 = spd1;
    }

    public Float getRecSpd1() {
        return recSpd1;
    }

    public void setRecSpd1(Float recSpd1) {
        this.recSpd1 = recSpd1;
    }

    public short getAlt1() {
        return alt1;
    }

    public void setAlt1(short alt1) {
        this.alt1 = alt1;
    }

    public short getDir1() {
        return dir1;
    }

    public void setDir1(short dir1) {
        this.dir1 = dir1;
    }

    public TrkAddt getAddt1() {
        return addt1;
    }

    public void setAddt1(TrkAddt addt1) {
        this.addt1 = addt1;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvNo() {
        return drvNo;
    }

    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    public String getPlatRgnId() {
        return platRgnId;
    }

    public void setPlatRgnId(String platRgnId) {
        this.platRgnId = platRgnId;
    }

    @Override
    public String toString() {
        return "CreateAlmReq{" +
                "id=" + id +
                ", simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", trkId=" + trkId +
                ", typ='" + typ + '\'' +
                ", subTyp='" + subTyp + '\'' +
                ", src=" + src +
                ", lvl=" + lvl +
                ", tm1=" + tm1 +
                ", recvTm1=" + recvTm1 +
                ", lng1=" + lng1 +
                ", lat1=" + lat1 +
                ", spd1=" + spd1 +
                ", recSpd1=" + recSpd1 +
                ", alt1=" + alt1 +
                ", dir1=" + dir1 +
                ", addt1=" + addt1 +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", platRgnId='" + platRgnId + '\'' +
                '}';
    }
}
