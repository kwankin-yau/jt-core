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

public class AlmNotif {

    public static final Type TYPE = new TypeToken<AlmNotif>(){}.getType();

    private long id;
    private long vehId;
    private String plateNo;
    private short plateColor;
    private String typ;
    private short lvl;
    private long tm1;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(short plateColor) {
        this.plateColor = plateColor;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public short getLvl() {
        return lvl;
    }

    public void setLvl(short lvl) {
        this.lvl = lvl;
    }

    public long getTm1() {
        return tm1;
    }

    public void setTm1(long tm1) {
        this.tm1 = tm1;
    }

    @Override
    public String toString() {
        return "AlmNotif{" +
                "id=" + id +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", typ='" + typ + '\'' +
                ", lvl=" + lvl +
                ", tm1=" + tm1 +
                '}';
    }
}

