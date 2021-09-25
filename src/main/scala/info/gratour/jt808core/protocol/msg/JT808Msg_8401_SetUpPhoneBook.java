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
import info.gratour.jt808core.protocol.msg.types.JT808PhoneBookEntry;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8401_SetUpPhoneBook;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_UP_PHONE_BOOK_8401)
public class JT808Msg_8401_SetUpPhoneBook extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.SET_UP_PHONE_BOOK_8401;

    public JT808Msg_8401_SetUpPhoneBook() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8401_SetUpPhoneBook(JT808FrameHeader header) {
        super(header);
    }

    private CP_8401_SetUpPhoneBook params;

    public CP_8401_SetUpPhoneBook getParams() {
        return params;
    }

    public void setParams(CP_8401_SetUpPhoneBook params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8401_SetUpPhoneBook{" +
                "params=" + params +
                "} " + super.toString();
    }
}
