/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

import info.gratour.common.types.EpochMillis;
import info.gratour.jtmodel.Coordinate;

import java.util.List;

public class TermRgn implements Shape {

    private String simNo;
    private Long vehId;
    private String plateNo;
    private Short plateColor;
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
    private Short timeThreshold;
    private boolean enabled;
    private boolean sync;
    private EpochMillis updateTm;
    private EpochMillis syncTm;

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

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
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

    private static final Coordinate[] EMPTY_VECTORS = new Coordinate[0];

    public Coordinate[] getVectorsArray() {
        if (vectors != null) {
            Coordinate[] r = new Coordinate[vectors.size()];
            return vectors.toArray(r);
        } else
            return EMPTY_VECTORS;
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

    public Short getTimeThreshold() {
        return timeThreshold;
    }

    public void setTimeThreshold(Short timeThreshold) {
        this.timeThreshold = timeThreshold;
    }

    public Byte getTimeThresholdByte() {
        if (timeThreshold != null)
            return timeThreshold.byteValue();
        else
            return null;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isSync() {
        return sync;
    }

    public void setSync(boolean sync) {
        this.sync = sync;
    }

    public EpochMillis getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(EpochMillis updateTm) {
        this.updateTm = updateTm;
    }

    public EpochMillis getSyncTm() {
        return syncTm;
    }

    public void setSyncTm(EpochMillis syncTm) {
        this.syncTm = syncTm;
    }

    @Override
    public String toString() {
        return "TermRgn{" +
                "simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
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
                ", enabled=" + enabled +
                ", sync=" + sync +
                ", updateTm=" + updateTm +
                ", syncTm=" + syncTm +
                '}';
    }
}
