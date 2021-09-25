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

public class JT808VTDR_PowerEvents_13 implements JT808VTDRDataBlock {
    private List<VTDR_PowerEvent> powerEvents;

    public List<VTDR_PowerEvent> getPowerEvents() {
        return powerEvents;
    }

    public void setPowerEvents(List<VTDR_PowerEvent> powerEvents) {
        this.powerEvents = powerEvents;
    }

    public void addPowerEvent(VTDR_PowerEvent powerEvent) {
        if (this.powerEvents == null)
            this.powerEvents = new ArrayList<>();

        this.powerEvents.add(powerEvent);
    }

    @Override
    public String toString() {
        return "JT808VTDR_PowerEvents{" +
                "powerEvents=" + powerEvents +
                '}';
    }
}
