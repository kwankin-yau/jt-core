/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import info.gratour.adaptor.types.CreateAlmReq;

public class WrappedAlmRptCreate {

    private CreateAlmReq alm;
    private String plateNo;
    private short plateColor;
    private long grpId;

    public CreateAlmReq getAlm() {
        return alm;
    }

    public void setAlm(CreateAlmReq alm) {
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

    @Override
    public String toString() {
        return "WrappedAlmRptCreate{" +
                "alm=" + alm +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                '}';
    }
}
