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
import info.gratour.jt808core.protocol.msg.types.JT808RectRegion;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8602_SetRectRegion;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_RECT_REGION_8602)
public class JT808Msg_8602_SetRectRegion extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_RECT_REGION_8602;

    public JT808Msg_8602_SetRectRegion() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8602_SetRectRegion(JT808FrameHeader header) {
        super(header);
    }

    private CP_8602_SetRectRegion params;

    public CP_8602_SetRectRegion getParams() {
        return params;
    }

    public void setParams(CP_8602_SetRectRegion params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8602_SetRectRegion{" +
                "params=" + params +
                "} " + super.toString();
    }
}
