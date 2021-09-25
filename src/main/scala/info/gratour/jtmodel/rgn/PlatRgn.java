/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

import info.gratour.common.types.EpochMillis;
import info.gratour.common.utils.BitUtils;
import info.gratour.jtmodel.Coordinate;

import java.util.List;

public class PlatRgn implements Shape {

    private String platRgnId;
    private String platRgnName;
    private long grpId;
    private String grpName;
    private int rgnId;
    private String rgnName;
    private String shp;
    private Coordinate center;
    private Integer radius;
    private List<Coordinate> vectors;
    private String rgnAlmRuleId;
    private String rgnAlmRuleName;
    private int attrs;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;
    private Integer parkTmThreshold;
    private String clr;
    private String description;
    private boolean enabled;
    private EpochMillis createTm;
    private EpochMillis updateTm;
    private List<PlatRgnGrp> grps;
    private List<PlatRgnVeh> vehs;

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

    public int getRgnId() {
        return rgnId;
    }

    public void setRgnId(int rgnId) {
        this.rgnId = rgnId;
    }

    public String getRgnName() {
        return rgnName;
    }

    public void setRgnName(String rgnName) {
        this.rgnName = rgnName;
    }

    public String getShp() {
        return shp;
    }

    public void setShp(String shp) {
        this.shp = shp;
    }

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public List<Coordinate> getVectors() {
        return vectors;
    }

    public void setVectors(List<Coordinate> vectors) {
        this.vectors = vectors;
    }

    public String getRgnAlmRuleId() {
        return rgnAlmRuleId;
    }

    public void setRgnAlmRuleId(String rgnAlmRuleId) {
        this.rgnAlmRuleId = rgnAlmRuleId;
    }

    public String getRgnAlmRuleName() {
        return rgnAlmRuleName;
    }

    public void setRgnAlmRuleName(String rgnAlmRuleName) {
        this.rgnAlmRuleName = rgnAlmRuleName;
    }

    public int getAttrs() {
        return attrs;
    }

    public void setAttrs(int attrs) {
        this.attrs = attrs;
    }

    public boolean isTimeRestricted() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__TIME_RESTRICTED);
    }

    public boolean isSpdRestricted() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__SPD_RESTRICTED);
    }

    public boolean isEnterRgnNotifyDriver() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__ENTER_RGN_NOTIFY_DRIVER);
    }

    public boolean isEnterRgnRecAlm() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__ENTER_RGN_REC_ALM);
    }

    public boolean isLeaveRgnNotifyDriver() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__LEAVE_RGN_NOTIFY_DRIVER);
    }

    public boolean isLeaveRgnRecAlm() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__LEAVE_RGN_REC_ALM);
    }

    public boolean isParkOverTimeAlmEnabled() {
        return BitUtils.test(attrs, RgnAlmRule.BIT__PARK_OVER_TIME_ALM_ENABLED);
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    public Short getSpdUpperLimit() {
        return spdUpperLimit;
    }

    public void setSpdUpperLimit(Short spdUpperLimit) {
        this.spdUpperLimit = spdUpperLimit;
    }

    public Byte getTimeThreshold() {
        return timeThreshold;
    }

    public void setTimeThreshold(Byte timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    public Integer getParkTmThreshold() {
        return parkTmThreshold;
    }

    public void setParkTmThreshold(Integer parkTmThreshold) {
        this.parkTmThreshold = parkTmThreshold;
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public EpochMillis getCreateTm() {
        return createTm;
    }

    public void setCreateTm(EpochMillis createTm) {
        this.createTm = createTm;
    }

    public EpochMillis getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(EpochMillis updateTm) {
        this.updateTm = updateTm;
    }

    public List<PlatRgnGrp> getGrps() {
        return grps;
    }

    public void setGrps(List<PlatRgnGrp> grps) {
        this.grps = grps;
    }

    public PlatRgn addGrp(PlatRgnGrp grp) {
        if (grps == null)
            grps = new java.util.ArrayList<>();

        grps.add(grp);
        return this;
    }

    public boolean isBoundToVeh(long vehId) {
        if (vehs != null) {
            for (PlatRgnVeh v : vehs) {
                if (v.getVehId() == vehId)
                    return true;
            }
        }

        return false;
    }

    public List<PlatRgnVeh> getVehs() {
        return vehs;
    }

    public void setVehs(List<PlatRgnVeh> vehs) {
        this.vehs = vehs;
    }

    public PlatRgn addVeh(PlatRgnVeh veh) {
        if (vehs == null)
            vehs = new java.util.ArrayList<>();

        vehs.add(veh);
        return this;
    }

    @Override
    public String toString() {
        return "PlatRgn{" +
                "platRgnId='" + platRgnId + '\'' +
                ", platRgnName='" + platRgnName + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", rgnId=" + rgnId +
                ", rgnName='" + rgnName + '\'' +
                ", shp='" + shp + '\'' +
                ", center=" + center +
                ", radius=" + radius +
                ", vectors=" + vectors +
                ", rgnAlmRuleId='" + rgnAlmRuleId + '\'' +
                ", rgnAlmRuleName='" + rgnAlmRuleName + '\'' +
                ", attrs=" + attrs +
                ", startTm='" + startTm + '\'' +
                ", endTm='" + endTm + '\'' +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                ", parkTmThreshold=" + parkTmThreshold +
                ", clr='" + clr + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", createTm=" + createTm +
                ", updateTm=" + updateTm +
                ", grps=" + grps +
                ", vehs=" + vehs +
                '}';
    }
}
