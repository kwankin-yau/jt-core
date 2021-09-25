/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

public class VTDR_PowerEvent {

    public static final int TYP_POWER_ON = 1;
    public static final int TYP_POWER_OFF = 2;

    private String time;
    private byte typ;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "VTDR_PowerEvent{" +
                "time='" + time + '\'' +
                ", typ=" + typ +
                '}';
    }
}
