/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808PhoneBookEntry;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_PHONE_BOOK_8401)
public class CP_8401_SetUpPhoneBook implements JT808CmdParams {

    private byte action;
    private JT808PhoneBookEntry[] entries;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808PhoneBookEntry[] getEntries() {
        return entries;
    }

    public void setEntries(JT808PhoneBookEntry[] entries) {
        this.entries = entries;
    }

    @Override
    public String toString() {
        return "CP_8401_SetUpPhoneBook{" +
                "action=" + action +
                ", entries=" + Arrays.toString(entries) +
                '}';
    }
}
