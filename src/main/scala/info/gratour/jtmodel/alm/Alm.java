/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import info.gratour.common.CommonMessages;
import info.gratour.common.types.EpochMillis;
import info.gratour.jtcommon.JTMessages;
import info.gratour.jtmodel.trk.TrkAddt;

public class Alm {

    public static final int ALM_SRC__TERM = 1;
    public static final int ALM_SRC__PLATFORM = 2;
    public static final int ALM_SRC__GOV = 3;

    public static final String MESSAGE_KEY_ALM_SRC__TERM = "almSrc.term.1";
    public static final String MESSAGE_KEY_ALM_SRC__PLATFORM = "almSrc.platform.2";
    public static final String MESSAGE_KEY_ALM_SRC__GOV = "almSrc.gov.3";

    public static String almSrcText(int almSrc) {
        String key;

        switch (almSrc) {
            case ALM_SRC__TERM:
                key = MESSAGE_KEY_ALM_SRC__TERM;
                break;

            case ALM_SRC__PLATFORM:
                key = MESSAGE_KEY_ALM_SRC__PLATFORM;
                break;

            case ALM_SRC__GOV:
                key = MESSAGE_KEY_ALM_SRC__GOV;
                break;

            default:
                return CommonMessages.UNKNOWN();
        }

        return JTMessages.get(key);
    }

    public static final int PROC_ST__PROCESSING = 0;
    public static final int PROC_ST__PROCESSED = 1;
    public static final int PROC_ST__NO_ACTION_TAKEN = 2;
    public static final int PROC_ST__DEFERRED = 3;

    public static final String MESSAGE_KEY_PROC_ST__UNPROCESSED = "almProcSt.unprocessed";
    public static final String MESSAGE_KEY_PROC_ST__PROCESSING = "almProcSt.processing.0";
    public static final String MESSAGE_KEY_PROC_ST__PROCESSED = "almProcSt.processed.1";
    public static final String MESSAGE_KEY_PROC_ST__NO_ACTION_TAKEN = "almProcSt.noActionTaken.2";
    public static final String MESSAGE_KEY_PROC_ST__DEFERRED = "almProcSt.deferred.3";

    public static String procStText(int procSt) {
        String key;

        switch (procSt) {
            case PROC_ST__PROCESSING:
                key = MESSAGE_KEY_PROC_ST__PROCESSING;
                break;

            case PROC_ST__PROCESSED:
                key = MESSAGE_KEY_PROC_ST__PROCESSED;
                break;

            case PROC_ST__NO_ACTION_TAKEN:
                key = MESSAGE_KEY_PROC_ST__NO_ACTION_TAKEN;
                break;

            case PROC_ST__DEFERRED:
                key = MESSAGE_KEY_PROC_ST__DEFERRED;
                break;

            default:
                return CommonMessages.UNKNOWN();
        }

        return JTMessages.get(key);
    }

    public static final int LVL__1 = 1;
    public static final int LVL__2 = 2;

    public static final String MESSAGE_KEY_LVL__1 = "almLvl.1";
    public static final String MESSAGE_KEY_LVL__2 = "almLvl.2";

    public static String almLvlText(int lvl) {
        String key;

        switch (lvl) {
            case LVL__1:
                key = MESSAGE_KEY_LVL__1;
                break;

            case LVL__2:
                key = MESSAGE_KEY_LVL__2;
                break;

            default:
                return "";
        }

        return JTMessages.get(key);
    }

    public static final int PROC_METH__TAKE_PHOTO = 0;
    public static final int PROC_METH__SEND_VOICE = 1;
    public static final int PROC_METH__NO_ACTION_TAKEN = 2;
    public static final int PROC_METH__OTHER = 3;

    public static final String MESSAGE_KEY_PROC_METH__TAKE_PHOTO = "procMeth.takePhoto.0";
    public static final String MESSAGE_KEY_PROC_METH__SEND_VOICE = "procMeth.sendVoice.1";
    public static final String MESSAGE_KEY_PROC_METH__NO_ACTION_TAKEN = "procMeth.noActionTaken.2";
    public static final String MESSAGE_KEY_PROC_METH__OTHER = "procMeth.other.3";

    public static String procMethText(int procMeth) {
        String key;
        switch (procMeth) {
            case PROC_METH__TAKE_PHOTO:
                key = MESSAGE_KEY_PROC_METH__TAKE_PHOTO;
                break;

            case PROC_METH__SEND_VOICE:
                key = MESSAGE_KEY_PROC_METH__SEND_VOICE;
                break;

            case PROC_METH__NO_ACTION_TAKEN:
                key = MESSAGE_KEY_PROC_METH__NO_ACTION_TAKEN;
                break;

            case PROC_METH__OTHER:
                key = MESSAGE_KEY_PROC_METH__OTHER;
                break;

            default:
                return CommonMessages.UNKNOWN();
        }

        return JTMessages.get(key);
    }


    private long id;
    private String simNo;
    private long vehId;
    private String plateNo;
    private Short plateColor;
    private long grpId;
    private String grpName;
    private long trkId;
    private String typ;
    private String subTyp;
    private short src;
    private Short lvl;
    private boolean actv;

    private EpochMillis tm1;
    private EpochMillis recvTm1;
    private double lng1;
    private double lat1;
    private float spd1;
    private Float recSpd1;
    private short alt1;
    private short dir1;
    private TrkAddt addt1;

    private EpochMillis tm0;
    private EpochMillis recvTm0;
    private double lng0;
    private double lat0;
    private float spd0;
    private Float recSpd0;
    private short alt0;
    private short dir0;
    private TrkAddt addt0;

    private Integer dur;
    private short attCnt;

    private String drvName;
    private String drvNo;

    private String platRgnId;
    private String platRgnName;

    private Short procSt;
    private Short procMeth;
    private EpochMillis procTm;
    private String oprName;
    private String oprCorpName;
    private String supervId;
    private EpochMillis supervTm;
    private EpochMillis supervDeadline;
    private Boolean supervReplyNeeded;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
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

    public long getTrkId() {
        return trkId;
    }

    public void setTrkId(long trkId) {
        this.trkId = trkId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getSubTyp() {
        return subTyp;
    }

    public void setSubTyp(String subTyp) {
        this.subTyp = subTyp;
    }

    public short getSrc() {
        return src;
    }

    public void setSrc(short src) {
        this.src = src;
    }

    public Short getLvl() {
        return lvl;
    }

    public void setLvl(Short lvl) {
        this.lvl = lvl;
    }

    public boolean isActv() {
        return actv;
    }

    public void setActv(boolean actv) {
        this.actv = actv;
    }

    public EpochMillis getTm1() {
        return tm1;
    }

    public void setTm1(EpochMillis tm1) {
        this.tm1 = tm1;
    }

    public EpochMillis getRecvTm1() {
        return recvTm1;
    }

    public void setRecvTm1(EpochMillis recvTm1) {
        this.recvTm1 = recvTm1;
    }

    public double getLng1() {
        return lng1;
    }

    public void setLng1(double lng1) {
        this.lng1 = lng1;
    }

    public double getLat1() {
        return lat1;
    }

    public void setLat1(double lat1) {
        this.lat1 = lat1;
    }

    public float getSpd1() {
        return spd1;
    }

    public void setSpd1(float spd1) {
        this.spd1 = spd1;
    }

    public Float getRecSpd1() {
        return recSpd1;
    }

    public void setRecSpd1(Float recSpd1) {
        this.recSpd1 = recSpd1;
    }

    public short getAlt1() {
        return alt1;
    }

    public void setAlt1(short alt1) {
        this.alt1 = alt1;
    }

    public short getDir1() {
        return dir1;
    }

    public void setDir1(short dir1) {
        this.dir1 = dir1;
    }

    public TrkAddt getAddt1() {
        return addt1;
    }

    public void setAddt1(TrkAddt addt1) {
        this.addt1 = addt1;
    }

    public EpochMillis getTm0() {
        return tm0;
    }

    public void setTm0(EpochMillis tm0) {
        this.tm0 = tm0;
    }

    public EpochMillis getRecvTm0() {
        return recvTm0;
    }

    public void setRecvTm0(EpochMillis recvTm0) {
        this.recvTm0 = recvTm0;
    }

    public double getLng0() {
        return lng0;
    }

    public void setLng0(double lng0) {
        this.lng0 = lng0;
    }

    public double getLat0() {
        return lat0;
    }

    public void setLat0(double lat0) {
        this.lat0 = lat0;
    }

    public float getSpd0() {
        return spd0;
    }

    public void setSpd0(float spd0) {
        this.spd0 = spd0;
    }

    public Float getRecSpd0() {
        return recSpd0;
    }

    public void setRecSpd0(Float recSpd0) {
        this.recSpd0 = recSpd0;
    }

    public short getAlt0() {
        return alt0;
    }

    public void setAlt0(short alt0) {
        this.alt0 = alt0;
    }

    public short getDir0() {
        return dir0;
    }

    public void setDir0(short dir0) {
        this.dir0 = dir0;
    }

    public TrkAddt getAddt0() {
        return addt0;
    }

    public void setAddt0(TrkAddt addt0) {
        this.addt0 = addt0;
    }

    public Integer getDur() {
        return dur;
    }

    public void setDur(Integer dur) {
        this.dur = dur;
    }

    public short getAttCnt() {
        return attCnt;
    }

    public void setAttCnt(short attCnt) {
        this.attCnt = attCnt;
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

    public Short getProcSt() {
        return procSt;
    }

    public void setProcSt(Short procSt) {
        this.procSt = procSt;
    }

    public Short getProcMeth() {
        return procMeth;
    }

    public void setProcMeth(Short procMeth) {
        this.procMeth = procMeth;
    }

    public EpochMillis getProcTm() {
        return procTm;
    }

    public void setProcTm(EpochMillis procTm) {
        this.procTm = procTm;
    }

    public String getOprName() {
        return oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getOprCorpName() {
        return oprCorpName;
    }

    public void setOprCorpName(String oprCorpName) {
        this.oprCorpName = oprCorpName;
    }

    public String getSupervId() {
        return supervId;
    }

    public void setSupervId(String supervId) {
        this.supervId = supervId;
    }

    public EpochMillis getSupervTm() {
        return supervTm;
    }

    public void setSupervTm(EpochMillis supervTm) {
        this.supervTm = supervTm;
    }

    public EpochMillis getSupervDeadline() {
        return supervDeadline;
    }

    public void setSupervDeadline(EpochMillis supervDeadline) {
        this.supervDeadline = supervDeadline;
    }

    public Boolean getSupervReplyNeeded() {
        return supervReplyNeeded;
    }

    public void setSupervReplyNeeded(Boolean supervReplyNeeded) {
        this.supervReplyNeeded = supervReplyNeeded;
    }

    public boolean isSupervReplyNeeded() {
        return (supervReplyNeeded != null) && supervReplyNeeded;
    }

    @Override
    public String toString() {
        return "Alm{" +
                "id=" + id +
                ", simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", trkId=" + trkId +
                ", typ='" + typ + '\'' +
                ", subTyp='" + subTyp + '\'' +
                ", src=" + src +
                ", lvl=" + lvl +
                ", actv=" + actv +
                ", tm1=" + tm1 +
                ", recvTm1=" + recvTm1 +
                ", lng1=" + lng1 +
                ", lat1=" + lat1 +
                ", spd1=" + spd1 +
                ", recSpd1=" + recSpd1 +
                ", alt1=" + alt1 +
                ", dir1=" + dir1 +
                ", addt1=" + addt1 +
                ", tm0=" + tm0 +
                ", recvTm0=" + recvTm0 +
                ", lng0=" + lng0 +
                ", lat0=" + lat0 +
                ", spd0=" + spd0 +
                ", recSpd0=" + recSpd0 +
                ", alt0=" + alt0 +
                ", dir0=" + dir0 +
                ", addt0=" + addt0 +
                ", dur=" + dur +
                ", attCnt=" + attCnt +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", platRgnId='" + platRgnId + '\'' +
                ", platRgnName='" + platRgnName + '\'' +
                ", procSt=" + procSt +
                ", procMeth=" + procMeth +
                ", procTm=" + procTm +
                ", oprName='" + oprName + '\'' +
                ", oprCorpName='" + oprCorpName + '\'' +
                ", supervId='" + supervId + '\'' +
                ", supervTm=" + supervTm +
                ", supervDeadline=" + supervDeadline +
                ", supervReplyNeeded=" + supervReplyNeeded +
                '}';
    }
}
