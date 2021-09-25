/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

public class PlatRgnVeh {

    private String platRgnId;
    private String platRgnName;
    private long vehId;
    private String plateNo;
    private Short plateColor;

    public String getPlatRgnId() {
        return platRgnId;
    }

    public void setPlatRgnId(String platRgnId) {
        this.platRgnId = platRgnId;
    }

    public String getPlatRgnName() {
        return platRgnName;
    }

    public void setPlatRgnName(String platRgnName) {
        this.platRgnName = platRgnName;
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

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    @Override
    public String toString() {
        return "PlatRgnVeh{" +
                "platRgnId='" + platRgnId + '\'' +
                ", platRgnName='" + platRgnName + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                '}';
    }
}
