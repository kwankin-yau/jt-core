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

public class VTDR_LocationInfoPerHour {

    private String startTime;
    private List<VTDR_LocationAndSpd> locationAndSpd;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public List<VTDR_LocationAndSpd> getLocationAndSpd() {
        return locationAndSpd;
    }

    public void setLocationAndSpd(List<VTDR_LocationAndSpd> locationAndSpd) {
        this.locationAndSpd = locationAndSpd;
    }

    public void addLcoationAndSpd(VTDR_LocationAndSpd locationAndSpd) {
        if (this.locationAndSpd == null)
            this.locationAndSpd = new ArrayList<>();

        this.locationAndSpd.add(locationAndSpd);
    }

    @Override
    public String toString() {
        return "VTDR_LocationInfoPerHour{" +
                "startTime='" + startTime + '\'' +
                ", locationAndSpd=" + locationAndSpd +
                '}';
    }
}
