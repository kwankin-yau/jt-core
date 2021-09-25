/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.trk;

public class AdasDriverBehavAlmAddt {

    public static final byte FLAG__NOT_AVAILABLE = 0;
    public static final byte FLAG__START = 1;
    public static final byte FLAG__END = 2;

    public static final byte TYP__FATIGUED = 1;
    public static final byte TYP__PHONE_CALL = 2;
    public static final byte TYP__SMOKE = 3;
    public static final byte TYP__NO_LOOK_AHEAD = 4;
    public static final byte TYP__DRIVER_NOT_DETECTED = 5;
    public static final byte TYP__STEERING_WHEEL_NOT_HOLDING = 6;
    public static final byte TYP__DRIVER_BEHAV_ALM_FUNC_FAILURE = 7;
    public static final byte TYP__NOT_BELTING = 8;
    public static final byte TYP__AUTO_CAPTURE = 0x10;
    public static final byte TYP__DRIVER_CHANGED_EVENT = 0x11;
    public static final byte TYP__INVALID_DRIVER_ID = 0x12;


    private int almId;
    private byte flag;
    private byte typ;
    private byte lvl;
    private byte fatigue;
    private short spd;
    private short alt;
    private double lat;
    private double lng;
    private long tm;
    private short vehSt;
    private String almNo;

    public int getAlmId() {
        return almId;
    }

    public void setAlmId(int almId) {
        this.almId = almId;
    }

    public byte getFlag() {
        return flag;
    }

    public void setFlag(byte flag) {
        this.flag = flag;
    }

    public boolean flagIsStartOrNA() {
        return flag == FLAG__NOT_AVAILABLE || flag == FLAG__START;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public byte getLvl() {
        return lvl;
    }

    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    public byte getFatigue() {
        return fatigue;
    }

    public void setFatigue(byte fatigue) {
        this.fatigue = fatigue;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public short getAlt() {
        return alt;
    }

    public void setAlt(short alt) {
        this.alt = alt;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }

    public short getVehSt() {
        return vehSt;
    }

    public void setVehSt(short vehSt) {
        this.vehSt = vehSt;
    }

    public String getAlmNo() {
        return almNo;
    }

    public void setAlmNo(String almNo) {
        this.almNo = almNo;
    }

    @Override
    public String toString() {
        return "AdasDriverBehavAlmAddt{" +
                "almId=" + almId +
                ", flag=" + flag +
                ", typ=" + typ +
                ", lvl=" + lvl +
                ", fatigue=" + fatigue +
                ", spd=" + spd +
                ", alt=" + alt +
                ", lat=" + lat +
                ", lng=" + lng +
                ", tm=" + tm +
                ", vehSt=" + vehSt +
                ", almNo='" + almNo + '\'' +
                '}';
    }
}
