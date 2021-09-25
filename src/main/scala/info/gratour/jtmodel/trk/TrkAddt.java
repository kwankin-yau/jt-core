/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.trk;

import com.google.gson.reflect.TypeToken;
import info.gratour.common.Consts;

import java.lang.reflect.Type;

public class TrkAddt {

    public static final Type TYPE = new TypeToken<TrkAddt>(){}.getType();

    private long id;

    /**
     * 卫星数
     */
    private Short sat;

    /**
     * 网络信号强度
     */
    private Short netSigStr;

    private Integer confirmAlmId;
    private OverSpdAddt overSpd;
    private AcrossAreaAddt acrossArea;
    private RouteAlmAddt routeAlm;
    private AnalogQty anQty;
    private Integer vidLoss;
    private Integer vidCover;
    private Short vidStgAlm;
    private UnusualDriveBehav unusualDriveBehav;

    /**
     * adas
     */
    private AdasDrivingAssistAlmAddt drivingAssistAlm;
    private AdasDriverBehavAlmAddt driverBehavAlm;
    private AdasTyreState tyreState;
    private AdasBlindAreaAlmAddt blindArea;
    private AdasIntenseDrivingAlmAddt intenseDrivingAlm;
    private AdasOverSpdAlmAddt adasOverSpd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Short getSat() {
        return sat;
    }

    public void setSat(Short sat) {
        this.sat = sat;
    }

    public Short getNetSigStr() {
        return netSigStr;
    }

    public void setNetSigStr(Short netSigStr) {
        this.netSigStr = netSigStr;
    }

    public Integer getConfirmAlmId() {
        return confirmAlmId;
    }

    public void setConfirmAlmId(Integer confirmAlmId) {
        this.confirmAlmId = confirmAlmId;
    }

    public OverSpdAddt getOverSpd() {
        return overSpd;
    }

    public void setOverSpd(OverSpdAddt overSpd) {
        this.overSpd = overSpd;
    }

    public AcrossAreaAddt getAcrossArea() {
        return acrossArea;
    }

    public void setAcrossArea(AcrossAreaAddt acrossArea) {
        this.acrossArea = acrossArea;
    }

    public RouteAlmAddt getRouteAlm() {
        return routeAlm;
    }

    public void setRouteAlm(RouteAlmAddt routeAlm) {
        this.routeAlm = routeAlm;
    }

    public AnalogQty getAnQty() {
        return anQty;
    }

    public void setAnQty(AnalogQty anQty) {
        this.anQty = anQty;
    }

    public Integer getVidLoss() {
        return vidLoss;
    }

    public void setVidLoss(Integer vidLoss) {
        this.vidLoss = vidLoss;
    }

    public Integer getVidCover() {
        return vidCover;
    }

    public void setVidCover(Integer vidCover) {
        this.vidCover = vidCover;
    }

    public Short getVidStgAlm() {
        return vidStgAlm;
    }

    public void setVidStgAlm(Short vidStgAlm) {
        this.vidStgAlm = vidStgAlm;
    }

    public UnusualDriveBehav getUnusualDriveBehav() {
        return unusualDriveBehav;
    }

    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        this.unusualDriveBehav = unusualDriveBehav;
    }

    public AdasDrivingAssistAlmAddt getDrivingAssistAlm() {
        return drivingAssistAlm;
    }

    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt drivingAssistAlm) {
        this.drivingAssistAlm = drivingAssistAlm;
    }

    public AdasDriverBehavAlmAddt getDriverBehavAlm() {
        return driverBehavAlm;
    }

    public void setDriverBehavAlm(AdasDriverBehavAlmAddt driverBehavAlm) {
        this.driverBehavAlm = driverBehavAlm;
    }

    public AdasTyreState getTyreState() {
        return tyreState;
    }

    public void setTyreState(AdasTyreState tyreState) {
        this.tyreState = tyreState;
    }

    public AdasBlindAreaAlmAddt getBlindArea() {
        return blindArea;
    }

    public void setBlindArea(AdasBlindAreaAlmAddt blindArea) {
        this.blindArea = blindArea;
    }

    public AdasIntenseDrivingAlmAddt getIntenseDrivingAlm() {
        return intenseDrivingAlm;
    }

    public void setIntenseDrivingAlm(AdasIntenseDrivingAlmAddt intenseDrivingAlm) {
        this.intenseDrivingAlm = intenseDrivingAlm;
    }

    public AdasOverSpdAlmAddt getAdasOverSpd() {
        return adasOverSpd;
    }

    public void setAdasOverSpd(AdasOverSpdAlmAddt adasOverSpd) {
        this.adasOverSpd = adasOverSpd;
    }

    @Override
    public String toString() {
        return Consts.GSON.toJson(this);
//        "TrkAddt{" +
//                "id=" + id +
//                ", sat=" + sat +
//                ", netSigStr=" + netSigStr +
//                ", confirmAlmId=" + confirmAlmId +
//                ", overSpd=" + overSpd +
//                ", acrossArea=" + acrossArea +
//                ", routeAlm=" + routeAlm +
//                ", anQty=" + anQty +
//                ", unusualDriveBehav=" + unusualDriveBehav +
//                ", drivingAssistAlm=" + drivingAssistAlm +
//                ", driverBehavAlm=" + driverBehavAlm +
//                ", tyreState=" + tyreState +
//                ", blindArea=" + blindArea +
//                ", intenseDrivingAlm=" + intenseDrivingAlm +
//                ", adasOverSpd=" + adasOverSpd +
//                '}';
    }
}
