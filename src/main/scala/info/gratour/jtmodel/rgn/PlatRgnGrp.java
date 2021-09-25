/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

public class PlatRgnGrp {
    private String platRgnId;
    private String platRgnName;
    private long grpId;
    private String grpName;

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

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    @Override
    public String toString() {
        return "PlatRgnGrp{" +
                "platRgnId='" + platRgnId + '\'' +
                ", platRgnName='" + platRgnName + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                '}';
    }
}
