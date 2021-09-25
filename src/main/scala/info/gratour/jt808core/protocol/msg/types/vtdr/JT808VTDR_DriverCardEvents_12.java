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

public class JT808VTDR_DriverCardEvents_12 implements JT808VTDRDataBlock {
    private List<VTDR_CardEvent> cardEvents;

    public List<VTDR_CardEvent> getCardEvents() {
        return cardEvents;
    }

    public void setCardEvents(List<VTDR_CardEvent> cardEvents) {
        this.cardEvents = cardEvents;
    }

    public void addCardEvent(VTDR_CardEvent cardEvent) {
        if (this.cardEvents == null)
            this.cardEvents = new ArrayList<>();

        this.cardEvents.add(cardEvent);
    }

    @Override
    public String toString() {
        return "JT808VTDR_DriverCardEvents{" +
                "cardEvents=" + cardEvents +
                '}';
    }
}
