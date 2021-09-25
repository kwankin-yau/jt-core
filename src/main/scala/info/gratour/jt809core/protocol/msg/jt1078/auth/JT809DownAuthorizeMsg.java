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

@JTMsgId(JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_9700)
public class JT809DownAuthorizeMsg extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_9700;

    public JT809DownAuthorizeMsg() {
        setMsgId(MSG_ID);
    }

    private int dataType;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }
}
