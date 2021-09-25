/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import info.gratour.adaptor.types.CloseAlmReq;

public class WrappedAlmRptClose {

    private short src;
    private String typ;
    private Short lvl;
    private CloseAlmReq alm;
    private String plateNo;
    private short plateColor;
    private long grpId;
    private String drvName;
    private String drvNo;

    public short getSrc() {
        return src;
    }

    public void setSrc(short src) {
        this.src = src;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Short getLvl() {
        return lvl;
    }

    public void setLvl(Short lvl) {
        this.lvl = lvl;
    }

    public CloseAlmReq getAlm() {
        return alm;
    }

    public void setAlm(CloseAlmReq alm) {
        this.alm = alm;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(short plateColor) {
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

    @Override
    public String toString() {
        return "WrappedAlmRptClose{" +
                "src=" + src +
                ", typ='" + typ + '\'' +
                ", lvl=" + lvl +
                ", alm=" + alm +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                '}';
    }
}
