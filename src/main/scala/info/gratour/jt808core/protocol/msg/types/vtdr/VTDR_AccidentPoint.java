/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;

public class VTDR_AccidentPoint {

    private String endTime;
    private String licenseNo;
    private short spd;
    private byte status;
    private List<VTDR_SpdAndStatus> spdAndStatus;

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

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

    public List<VTDR_SpdAndStatus> getSpdAndStatus() {
        return spdAndStatus;
    }

    public void setSpdAndStatus(List<VTDR_SpdAndStatus> spdAndStatus) {
        this.spdAndStatus = spdAndStatus;
    }

    public void addSpdAndStatus(VTDR_SpdAndStatus spdAndStatus) {
        if (this.spdAndStatus == null)
            this.spdAndStatus = new ArrayList<>();

        this.spdAndStatus.add(spdAndStatus);
    }

    @Override
    public String toString() {
        return "VTDR_AccidentPoint{" +
                "endTime='" + endTime + '\'' +
                ", licenseNo='" + licenseNo + '\'' +
                ", spd=" + spd +
                ", status=" + status +
                ", spdAndStatus=" + spdAndStatus +
                '}';
    }
}
