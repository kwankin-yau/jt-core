/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

import info.gratour.common.types.EpochMillis;

public class RgnAlmRule {

    public static boolean isInternalAlmRule(String rgnAlmRuleId) {
        if (rgnAlmRuleId != null)
            return rgnAlmRuleId.startsWith("s:");
        else
            return false;
    }

    public static final int BIT__TIME_RESTRICTED = 0;
    public static final int BIT__SPD_RESTRICTED = 1;
    public static final int BIT__ENTER_RGN_NOTIFY_DRIVER = 2;
    public static final int BIT__ENTER_RGN_REC_ALM = 3;
    public static final int BIT__LEAVE_RGN_NOTIFY_DRIVER = 4;
    public static final int BIT__LEAVE_RGN_REC_ALM = 5;
    public static final int BIT__DISABLE_DOOR = 8;
    public static final int BIT__ENTER_RGN_SHUTDOWN_COMM = 9;
    public static final int BIT__ENTER_RGN_COLLECT_LOCATION = 10;
    public static final int BIT__PARK_OVER_TIME_ALM_ENABLED = 31;

    private String rgnAlmRuleId;
    private String rgnAlmRuleName;
    private long grpId;
    private String grpName;
    private int attrs;
    private String startTm;
    private String endTm;
    private Short spdUpperLimit;
    private Byte timeThreshold;
    private Integer parkTmThreshold;
    private EpochMillis createTm;
    private EpochMillis updateTm;

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

    @Override
    public String toString() {
        return "RgnAlmRuler{" +
                "rgnAlmRuleId='" + rgnAlmRuleId + '\'' +
                ", rgnAlmRuleName='" + rgnAlmRuleName + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", attrs=" + attrs +
                ", startTm='" + startTm + '\'' +
                ", endTm='" + endTm + '\'' +
                ", spdUpperLimit=" + spdUpperLimit +
                ", timeThreshold=" + timeThreshold +
                ", parkTmThreshold=" + parkTmThreshold +
                ", createTm=" + createTm +
                ", updateTm=" + updateTm +
                '}';
    }
}
