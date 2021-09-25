/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808EventSetupItem;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_EVENT_8301)
public class CP_8301_SetUpEvent implements JT808CmdParams {

    private byte typ;
    private JT808EventSetupItem[] events;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public JT808EventSetupItem[] getEvents() {
        return events;
    }

    public void setEvents(JT808EventSetupItem[] events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "CP_8301_SetUpEvent{" +
                "typ=" + typ +
                ", events=" + Arrays.toString(events) +
                '}';
    }
}
