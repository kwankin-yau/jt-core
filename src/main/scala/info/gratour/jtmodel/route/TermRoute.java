/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.route;

import info.gratour.common.types.EpochMillis;

public class TermRoute {

    private String simNo;
    private Long vehId;
    private String plateNo;
    private Short plateColor;
    private long grpId;
    private String grpName;
    private long routeId;
    private String routeName;
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

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
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
        return "TermRoute{" +
                "simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", enabled=" + enabled +
                ", sync=" + sync +
                ", updateTm=" + updateTm +
                ", syncTm=" + syncTm +
                '}';
    }
}
