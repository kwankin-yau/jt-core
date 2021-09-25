/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.auth;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_STARTUP_REQ_ACK_9702)
public class JT809Msg_9702_DownAuthorizeMsgStartupReqAck extends JT809DownAuthorizeMsg {

    public static final int DATA_TYPE = JT809MsgConsts.AuthorizeMsgs.DOWN_AUTHORIZE_MSG_STARTUP_REQ_ACK_9702;

    public JT809Msg_9702_DownAuthorizeMsgStartupReqAck() {
        setDataType(DATA_TYPE);
    }

    private String plateNo;
    private short plateColor;

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(short plateColor) {
        this.plateColor = plateColor;
    }

    @Override
    public String toString() {
        return "JT809Msg_9702_DownAuthorizeMsgStartupReqAck{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                "} " + super.toString();
    }
}
