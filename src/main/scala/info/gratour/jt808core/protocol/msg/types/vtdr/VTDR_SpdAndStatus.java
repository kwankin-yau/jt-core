/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

public class VTDR_SpdAndStatus {

    private short spd;
    private byte status;

    public short getSpd() {
        return spd;
    }

    public void setSpd(short spd) {
        this.spd = spd;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "VTDR_SpdAndStatus{" +
                "spd=" + spd +
                ", status=" + status +
                '}';
    }
}
