package info.gratour.jt809core.protocol.msg.types;

import com.google.gson.JsonObject;
import info.gratour.common.types.EpochMillis;
import info.gratour.jt808core.JT808AlarmBit;
import info.gratour.jt808core.JT808StateBit;
import info.gratour.jtmodel.trk.Trk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * JT809-2011 table 69, vehicle location information structure
 */
public class JT809GnssData {

    private boolean encrypt;
    private LocalDate date;
    private LocalTime time;
    private double lon;
    private double lat;
    private int vec1;
    private int vec2;
    private int mileageKm;
    private short direction;
    private short altitude;
    private int stateBits;
    private int alarmBits;

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public void setDateTime(LocalDateTime ldt) {
        setDate(ldt.toLocalDate());
        setTime(ldt.toLocalTime());
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getVec1() {
        return vec1;
    }

    public void setVec1(int vec1) {
        this.vec1 = vec1;
    }

    public int getVec2() {
        return vec2;
    }

    public void setVec2(int vec2) {
        this.vec2 = vec2;
    }

    public int getMileageKm() {
        return mileageKm;
    }

    public void setMileageKm(int mileageKm) {
        this.mileageKm = mileageKm;
    }

    public short getDirection() {
        return direction;
    }

    public void setDirection(short direction) {
        this.direction = direction;
    }

    public short getAltitude() {
        return altitude;
    }

    public void setAltitude(short altitude) {
        this.altitude = altitude;
    }

    public int getStateBits() {
        return stateBits;
    }

    public void setStateBits(int stateBits) {
        this.stateBits = stateBits;
    }

    public int getAlarmBits() {
        return alarmBits;
    }

    public void setAlarmBits(int alarmBits) {
        this.alarmBits = alarmBits;
    }

    public void assign(Trk trk) {
        encrypt = trk.stTest(JT808StateBit.ENCRYPT.bitIndex());
        EpochMillis gpsTm = trk.getGpsTm();
        LocalDateTime dt = gpsTm.toLocalDateTimeBeijing();
        date = dt.toLocalDate();
        time = dt.toLocalTime();
        lon = trk.getLng();
        lat = trk.getLat();
        vec1 = (int) trk.getSpd();
        vec2 = (int) trk.recSpdDef0();
        mileageKm = (int) trk.mileDef0();
        direction = (short) trk.getDir();
        altitude = (short) trk.getAlt();
        stateBits = trk.getSt();
        alarmBits = trk.getAlm();
    }

    public JsonObject toJsonObject() {
        JsonObject o = new JsonObject();
        o.addProperty("encrypt", encrypt);
        o.addProperty("date", date.format(DateTimeFormatter.ISO_LOCAL_DATE));
        o.addProperty("time", time.format(DateTimeFormatter.ISO_LOCAL_TIME));
        o.addProperty("lon", lon);
        o.addProperty("lat", lat);
        o.addProperty("vec1", vec1);
        o.addProperty("vec2", vec2);
        o.addProperty("mileageKm", mileageKm);
        o.addProperty("direction", direction);
        o.addProperty("altitude", altitude);
        o.addProperty("stateBits", stateBits);
        o.addProperty("alarmBits", alarmBits);
        return o;
    }

    @Override
    public String toString() {
        return "JT809GnssData{" +
                "encrypt=" + encrypt +
                ", date=" + date.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                ", time=" + time.format(DateTimeFormatter.ISO_LOCAL_TIME) +
                ", lon=" + lon +
                ", lat=" + lat +
                ", vec1=" + vec1 +
                ", vec2=" + vec2 +
                ", mileageKm=" + mileageKm +
                ", direction=" + direction +
                ", altitude=" + altitude +
                ", stateBits=" + stateBits + " [" + JT808StateBit.vehStateText(stateBits) + "]" +
                ", alarmBits=" + alarmBits + " [" + JT808AlarmBit.vehAlarmText(alarmBits) + "]" +
                '}';
    }
}
