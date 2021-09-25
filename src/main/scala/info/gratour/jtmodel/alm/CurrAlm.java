/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import info.gratour.common.types.EpochMillis;

public class CurrAlm {

    private String simNo;
    private String typ;
    private String subTyp;
    private long almId;
    private short src;
    private Short lvl;
    private EpochMillis gpsTm1;
    private EpochMillis recvTm1;
    private long vehId;
    private String plateNo;
    private int plateColor;
    private long grpId;
    private String drvName;
    private String drvNo;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
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

    public long getAlmId() {
        return almId;
    }

    public void setAlmId(long almId) {
        this.almId = almId;
    }

    public EpochMillis getGpsTm1() {
        return gpsTm1;
    }

    public void setGpsTm1(EpochMillis gpsTm1) {
        this.gpsTm1 = gpsTm1;
    }

    public EpochMillis getRecvTm1() {
        return recvTm1;
    }

    public void setRecvTm1(EpochMillis recvTm1) {
        this.recvTm1 = recvTm1;
    }

    public long getVehId() {
        return vehId;
    }

    public void setVehId(long vehId) {
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

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
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

    @Override
    public String toString() {
        return "CurrAlm{" +
                "simNo='" + simNo + '\'' +
                ", typ='" + typ + '\'' +
                ", subTyp='" + subTyp + '\'' +
                ", almId=" + almId +
                ", src=" + src +
                ", lvl=" + lvl +
                ", gpsTm1=" + gpsTm1 +
                ", recvTm1=" + recvTm1 +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                '}';
    }
}
