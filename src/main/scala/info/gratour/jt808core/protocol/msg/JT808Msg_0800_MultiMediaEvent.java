/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg;

import info.gratour.jt808core.protocol.JT808FrameHeader;
import info.gratour.jt808core.protocol.JT808Msg;
import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.adaptor.mq.dto.types.MQEventAddt_0800_MultiMediaEvent;

@JTMsgId(JT808MsgConsts.MULTI_MEDIA_EVENT_0800)
public class JT808Msg_0800_MultiMediaEvent extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.MULTI_MEDIA_EVENT_0800;

    public JT808Msg_0800_MultiMediaEvent() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_0800_MultiMediaEvent(JT808FrameHeader header) {
        super(header);
    }

    private MQEventAddt_0800_MultiMediaEvent event;

    public MQEventAddt_0800_MultiMediaEvent getEvent() {
        return event;
    }

    public void setEvent(MQEventAddt_0800_MultiMediaEvent event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "JT808Msg_0800_MultiMediaEvent{" +
                "event=" + event +
                "} " + super.toString();
    }
}
