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

public class JT808VTDR_Locations_09 implements JT808VTDRDataBlock {

    private List<VTDR_LocationInfoPerHour> locations;

    public List<VTDR_LocationInfoPerHour> getLocations() {
        return locations;
    }

    public void setLocations(List<VTDR_LocationInfoPerHour> locations) {
        this.locations = locations;
    }

    public void addLocation(VTDR_LocationInfoPerHour locationInfoPerHour) {
        if (this.locations == null)
            this.locations = new ArrayList<>();

        this.locations.add(locationInfoPerHour);
    }

    @Override
    public String toString() {
        return "JT808VTDR_Locations{" +
                "locations=" + locations +
                '}';
    }
}
