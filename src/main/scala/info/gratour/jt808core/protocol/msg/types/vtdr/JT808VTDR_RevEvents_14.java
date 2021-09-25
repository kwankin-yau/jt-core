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

public class JT808VTDR_RevEvents_14 implements JT808VTDRDataBlock {

    private List<VTDR_RevEvent> revEvents;

    public List<VTDR_RevEvent> getRevEvents() {
        return revEvents;
    }

    public void setRevEvents(List<VTDR_RevEvent> revEvents) {
        this.revEvents = revEvents;
    }

    public void addRevEvent(VTDR_RevEvent event) {
        if (this.revEvents == null)
            this.revEvents = new ArrayList<>();

        this.revEvents.add(event);
    }

    @Override
    public String toString() {
        return "JT808VTDR_RevEvents{" +
                "revEvents=" + revEvents +
                '}';
    }
}
