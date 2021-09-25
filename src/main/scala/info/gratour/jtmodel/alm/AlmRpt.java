/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

public class AlmRpt {

    public static final int ST__UNDEFINED = 0;
    public static final int ST__START = 1;
    public static final int ST__STOP = 2;

    public static final int SRC__TERM = 1;
    public static final int SRC__ENT_PLATFORM = 2;
    public static final int SRC__GOV_PLATFORM = 3;
    public static final int SRC__OTHERS = 9;

    public static final int LVL__UNKNOWN = 0;
    public static final int LVL__1 = 1;
    public static final int LVL__2 = 2;

    private String id;
    private String plateNo;
    private short plateColor;
    private long grpId;
    private byte st;
    private int src;
    private String typ;
    private long tm;
    private String content;
    private String drvName;
    private String drvNo;
    private int lvl;
    private double lng;
    private double lat;
    private short alt;
    private short spd;
    private short recSpd;
    private short dir;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public byte getSt() {
        return st;
    }

    public void setSt(byte st) {
        this.st = st;
    }

    public boolean stIsStartOrUndefined() {
        return st == ST__START;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public int typValue() {
        return Integer.parseInt(typ, 16);
    }

    public long getTm() {
        return tm;
    }

    public void setTm(long tm) {
        this.tm = tm;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDrvName() {
        return drvName;
    }

    public void setDrvName(String drvName) {
        this.drvName = drvName;
    }

    public String getDrvNo() {
        return drvNo;
    }

    public void setDrvNo(String drvNo) {
        this.drvNo = drvNo;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public short getAlt() {
        return alt;
    }

    public void setAlt(short alt) {
        this.alt = alt;
    }

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public short getRecSpd() {
        return recSpd;
    }

    public void setRecSpd(short recSpd) {
        this.recSpd = recSpd;
    }

    public short getDir() {
        return dir;
    }

    public void setDir(short dir) {
        this.dir = dir;
    }

    @Override
    public String toString() {
        return "AlmRpt{" +
                "id='" + id + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", st=" + st +
                ", src=" + src +
                ", typ='" + typ + '\'' +
                ", tm=" + tm +
                ", content='" + content + '\'' +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", lvl=" + lvl +
                ", lng=" + lng +
                ", lat=" + lat +
                ", alt=" + alt +
                ", spd=" + spd +
                ", recSpd=" + recSpd +
                ", dir=" + dir +
                '}';
    }
}
