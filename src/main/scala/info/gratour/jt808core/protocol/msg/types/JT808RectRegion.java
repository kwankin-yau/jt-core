/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types;

import info.gratour.jtmodel.Coordinate;

public class JT808RectRegion {

    private int regionId;
    private short attrs;
    private Coordinate minXMinY;
    private Coordinate maxXMaxY;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public short getAttrs() {
        return attrs;
    }

    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    public Coordinate getMinXMinY() {
        return minXMinY;
    }

    public void setMinXMinY(Coordinate minXMinY) {
        this.minXMinY = minXMinY;
    }

    public Coordinate getMaxXMaxY() {
        return maxXMaxY;
    }

    public void setMaxXMaxY(Coordinate maxXMaxY) {
        this.maxXMaxY = maxXMaxY;
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

    @Override
    public String toString() {
        return "JT808RectRegion{" +
                "regionId=" + regionId +
                ", attrs=" + attrs +
                ", minXMinY=" + minXMinY +
                ", maxXMaxY=" + maxXMaxY +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                '}';
    }
}
