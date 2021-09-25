/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class UpdateTermRouteSyncReq {

    private String simNo;
    private long routeId;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    @Override
    public String toString() {
        return "UpdateTermRouteSyncReq{" +
                "simNo='" + simNo + '\'' +
                ", routeId=" + routeId +
                '}';
    }
}
