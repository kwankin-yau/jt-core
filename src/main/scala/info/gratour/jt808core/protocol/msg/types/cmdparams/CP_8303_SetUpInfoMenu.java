/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808InfoMenuItem;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_INFO_MENU_8303)
public class CP_8303_SetUpInfoMenu implements JT808CmdParams {

    private byte action;
    private JT808InfoMenuItem[] menuItems;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808InfoMenuItem[] getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(JT808InfoMenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public String toString() {
        return "CP_8303_SetUpInfoMenu{" +
                "action=" + action +
                ", menuItems=" + Arrays.toString(menuItems) +
                '}';
    }
}
