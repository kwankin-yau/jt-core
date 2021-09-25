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
import info.gratour.jt808core.protocol.msg.types.JT808InfoMenuItem;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8303_SetUpInfoMenu;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_INFO_MENU_8303)
public class JT808Msg_8303_SetUpInfoMenu extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_UP_INFO_MENU_8303;

    public JT808Msg_8303_SetUpInfoMenu() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8303_SetUpInfoMenu(JT808FrameHeader header) {
        super(header);
    }

    private CP_8303_SetUpInfoMenu params;

    public CP_8303_SetUpInfoMenu getParams() {
        return params;
    }

    public void setParams(CP_8303_SetUpInfoMenu params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8303_SetUpInfoMenu{" +
                "params=" + params +
                "} " + super.toString();
    }
}
