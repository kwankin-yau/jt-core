/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class UpdateTermRgnSyncReq {
    private String simNo;
    private long rgnId;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getRgnId() {
        return rgnId;
    }

    public void setRgnId(long rgnId) {
        this.rgnId = rgnId;
    }

    @Override
    public String toString() {
        return "UpdateTermRgnSyncReq{" +
                "simNo='" + simNo + '\'' +
                ", rgnId=" + rgnId +
                '}';
    }
}
