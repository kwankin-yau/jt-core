/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.auth;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_1700)
public class JT809UpAuthorizeMsg extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_1700;

    private int dataType;

    public JT809UpAuthorizeMsg() {
        setMsgId(MSG_ID);
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
