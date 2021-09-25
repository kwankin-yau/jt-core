package info.gratour.jtmodel.trk;

import com.google.gson.reflect.TypeToken;
import info.gratour.adaptor.mq.dto.types.MQEventAddt;
import info.gratour.common.types.EpochMillis;
import info.gratour.common.utils.BitUtils;
import info.gratour.jt808core.JT1078VidAlarmBit;
import info.gratour.jt808core.JT808AlarmBit;
import info.gratour.jt808core.JT808StateBit;

import java.lang.reflect.Type;

public class Trk implements MQEventAddt {

    public static final Type TYPE = new TypeToken<Trk>() {
    }.getType();

    public static class AdasAlarmBits {
        public static final int ADAS_DRIVING_ASSIST_ALARM = 0;
        public static final int ADAS_DRIVER_BEHAVIOR_ALARM = 1;
        public static final int ADAS_TYRE_STATE = 2;
        public static final int ADAS_BLIND_AREA = 3;
        public static final int ADAS_INTENSE_DRIVING_ALARM = 4;
        public static final int ADAS_OVER_SPEED_ALARM = 5;
    }

    private long id;

    private String simNo;
    private Long vehId;
    private String plateNo;
    private Short plateColor;
    private Long grpId;
    private String grpName;

    private EpochMillis recvTm;
    private EpochMillis gpsTm;

    private Boolean retrans;

    private int alm;
    private int st;
    private double lng;
    private double lat;
    private int alt;
    private float spd;
    private Float recSpd;
    private int dir;

    private Integer signal;
    private Short ioSt;


    private Integer vidAlm;
    private Short adasAlm;

    private Float mile;
    private Float gas;

    private String drvName;
    private String drvNo;

    private TrkAddt addt;

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

    public Long getGrpId() {
        return grpId;
    }

    public void setGrpId(Long grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public EpochMillis getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(EpochMillis recvTm) {
        this.recvTm = recvTm;
    }

    public EpochMillis getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(EpochMillis gpsTm) {
        this.gpsTm = gpsTm;
    }

    public boolean isRetrans() {
        return retrans != null ? retrans : false;
    }

    public Boolean getRetrans() {
        return retrans;
    }

    public void setRetrans(Boolean retrans) {
        this.retrans = retrans;
    }

    public int getAlm() {
        return alm;
    }

    public void setAlm(int alm) {
        this.alm = alm;
    }

    public boolean almTest(int bitIndex) {
        return BitUtils.test(alm, bitIndex);
    }

    public boolean almTest(JT808AlarmBit bit) {
        return BitUtils.test(alm, bit.bitIndex());
    }

    public int getSt() {
        return st;
    }

    public void setSt(int st) {
        this.st = st;
    }

    public boolean stTest(int bitIndex) {
        return BitUtils.test(st, bitIndex);
    }

    public boolean stTestAccOn() {
        return stTest(JT808StateBit.ACC_ON.bitIndex());
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

    public int getAlt() {
        return alt;
    }

    public void setAlt(int alt) {
        this.alt = alt;
    }

    public float getSpd() {
        return spd;
    }

    public void setSpd(float spd) {
        this.spd = spd;
    }

    public Float getRecSpd() {
        return recSpd;
    }

    public float recSpdDef0() {
        if (recSpd != null)
            return recSpd;
        else
            return 0f;
    }

    public void setRecSpd(Float recSpd) {
        this.recSpd = recSpd;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Integer getSignal() {
        return signal;
    }

    public void setSignal(Integer signal) {
        this.signal = signal;
    }

    public boolean signalTest(int bitIndex) {
        if (signal == null)
            return false;
        else
            return BitUtils.test(signal, bitIndex);
    }

    public Short getIoSt() {
        return ioSt;
    }

    public void setIoSt(Short ioSt) {
        this.ioSt = ioSt;
    }

    public boolean ioStTest(int bitIndex) {
        if (ioSt == null)
            return false;
        else
            return BitUtils.test(ioSt.intValue(), bitIndex);
    }

    public Integer getVidAlm() {
        return vidAlm;
    }

    public void setVidAlm(Integer vidAlm) {
        this.vidAlm = vidAlm;
    }

    public boolean vidAlmTest(int bitIndex) {
        if (vidAlm != null)
            return BitUtils.test(vidAlm, bitIndex);
        else
            return false;
    }

    public boolean vidAlmTest(JT1078VidAlarmBit bit) {
        if (vidAlm != null)
            return BitUtils.test(vidAlm, bit.bitIndex());
        else
            return false;
    }

    public Short getAdasAlm() {
        return adasAlm;
    }

    public void setAdasAlm(Short adasAlm) {
        this.adasAlm = adasAlm;
    }

    public boolean adasAlmTest(int bitIndex) {
        if (adasAlm != null)
            return BitUtils.test(adasAlm, bitIndex);
        else
            return false;
    }

    public Float getMile() {
        return mile;
    }

    public void setMile(Float mile) {
        this.mile = mile;
    }

    public float mileDef0() {
        if (mile == null)
            return 0f;
        else
            return mile;
    }

    public Float getGas() {
        return gas;
    }

    public void setGas(Float gas) {
        this.gas = gas;
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

    public TrkAddt getAddt() {
        return addt;
    }

    public void setAddt(TrkAddt addt) {
        this.addt = addt;
    }

    public short adasAlmSet(int alarmStateBitIndex) {
        int state;
        if (this.adasAlm != null)
            state = this.adasAlm;
        else
            state = 0;

        state = BitUtils.set(state, alarmStateBitIndex);
        this.adasAlm = (short) state;
        return (short) state;
    }

    public short adasAlmClear(int alarmStateBitIndex) {
        if (this.adasAlm == null)
            return 0;

        int state = this.adasAlm;

        state = BitUtils.clear(state, alarmStateBitIndex);
        this.adasAlm = (short) state;
        return (short) state;
    }

    protected TrkAddt prepareAddt() {
        if (addt == null) {
            addt = new TrkAddt();
            addt.setId(id);
        }

        return addt;
    }

    public void setUnusualDriveBehav(UnusualDriveBehav unusualDriveBehav) {
        if (unusualDriveBehav == null)
            throw new NullPointerException();

        prepareAddt().setUnusualDriveBehav(unusualDriveBehav);
    }

    public void setDrivingAssistAlm(AdasDrivingAssistAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDrivingAssistAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_DRIVING_ASSIST_ALARM);
    }

    public void setDriverBehavAlm(AdasDriverBehavAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setDriverBehavAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_DRIVER_BEHAVIOR_ALARM);
    }

    public void setAdasTyreState(AdasTyreState tyreState) {
        if (tyreState == null)
            throw new NullPointerException();

        prepareAddt().setTyreState(tyreState);
        adasAlmSet(AdasAlarmBits.ADAS_TYRE_STATE);
    }

    public void setAdasBlindAreaAlarm(AdasBlindAreaAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setBlindArea(alm);
        adasAlmSet(AdasAlarmBits.ADAS_BLIND_AREA);
    }

    public void setAdasIntenseDrivingAlarm(AdasIntenseDrivingAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setIntenseDrivingAlm(alm);
        adasAlmSet(AdasAlarmBits.ADAS_INTENSE_DRIVING_ALARM);
    }

    public void setAdasOverSpdAlarm(AdasOverSpdAlmAddt alm) {
        if (alm == null)
            throw new NullPointerException();

        prepareAddt().setAdasOverSpd(alm);
        adasAlmSet(AdasAlarmBits.ADAS_OVER_SPEED_ALARM);
    }

    @Override
    public String toString() {
        return "Trk{" +
                "id=" + id +
                ", simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", recvTm=" + recvTm +
                ", gpsTm=" + gpsTm +
                ", retrans=" + retrans +
                ", alm=" + alm +
                ", st=" + st +
                ", lng=" + lng +
                ", lat=" + lat +
                ", alt=" + alt +
                ", spd=" + spd +
                ", recSpd=" + recSpd +
                ", dir=" + dir +
                ", signal=" + signal +
                ", ioSt=" + ioSt +
                ", vidAlm=" + vidAlm +
                ", adasAlm=" + adasAlm +
                ", mile=" + mile +
                ", gas=" + gas +
                ", drvName='" + drvName + '\'' +
                ", drvNo='" + drvNo + '\'' +
                ", addt=" + addt +
                '}';
    }
}
