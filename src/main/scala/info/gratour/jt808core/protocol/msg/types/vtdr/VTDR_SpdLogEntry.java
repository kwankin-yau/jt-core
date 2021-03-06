/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

public class VTDR_SpdLogEntry {

    private short recSpd;
    private short refSpd;

    public short getRecSpd() {
        return recSpd;
    }

    public void setRecSpd(short recSpd) {
        this.recSpd = recSpd;
    }

    public short getRefSpd() {
        return refSpd;
    }

    public void setRefSpd(short refSpd) {
        this.refSpd = refSpd;
    }

    @Override
    public String toString() {
        return "VTDR_SpdLogEntry{" +
                "recSpd=" + recSpd +
                ", refSpd=" + refSpd +
                '}';
    }
}
