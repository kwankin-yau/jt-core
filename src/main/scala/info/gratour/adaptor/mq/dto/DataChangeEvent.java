/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DataChangeEvent {

    public static final Type TYPE = new TypeToken<DataChangeEvent>(){}.getType();

    public static final String TYP__VEH = "veh";
    public static final String TYP__TERM = "term";
    public static final String TYP__USER = "user";
    public static final String TYP__SYS_PARAM = "sysParam";
    public static final String TYP__ALM_PARAM = "almParam";
    public static final String TYP__GRP = "grp";
    public static final String TYP__PLAT_RGN = "platRgn";
    public static final String TYP__UPLOAD_TO_GOV_GRPS = "uploadToGovGrps";

    public static final String ACT__INSERT = "ins";
    public static final String ACT__UPDATE = "upd";
    public static final String ACT__DELETE = "del";

    private String typ;
    private String id;
    private String act;

    public DataChangeEvent() {
    }

    public DataChangeEvent(String typ, String id, String act) {
        this.typ = typ;
        this.id = id;
        this.act = act;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long idAsLong() {
        return Long.parseLong(id);
    }

    public String getAct() {
        return act;
    }

    public void setAct(String act) {
        this.act = act;
    }

    public static DataChangeEvent veh(long vehId, String act) {
        return new DataChangeEvent(TYP__VEH, String.valueOf(vehId), act);
    }

    public static DataChangeEvent term(String simNo, String act) {
        return new DataChangeEvent(TYP__TERM, simNo, act);
    }

    public static DataChangeEvent user(long userId, String act) {
        return new DataChangeEvent(TYP__USER, String.valueOf(userId), act);
    }

    public static DataChangeEvent grp(long grpId, String act) {
        return new DataChangeEvent(TYP__GRP, String.valueOf(grpId), act);
    }

    public static DataChangeEvent sysParam(String scope, String name, String act) {
        return new DataChangeEvent(TYP__SYS_PARAM, scope + "/" + name, act);
    }

    public static DataChangeEvent platRgn(String platRgnId, String act) {
        return new DataChangeEvent(TYP__PLAT_RGN, platRgnId, act);
    }

    public static DataChangeEvent uploadToGovGrpsChanged() {
        return new DataChangeEvent(TYP__UPLOAD_TO_GOV_GRPS, "", ACT__UPDATE);
    }

    @Override
    public String toString() {
        return "DataChangeEvent{" +
                "typ='" + typ + '\'' +
                ", id='" + id + '\'' +
                ", act='" + act + '\'' +
                '}';
    }
}
