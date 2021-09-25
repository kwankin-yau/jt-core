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

@JT809DataType(JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_STARTUP_1701)
public class JT809Msg_1701_UpAuthorizeMsgStartup extends JT809UpAuthorizeMsg {

    public static final int DATA_TYPE = JT809MsgConsts.AuthorizeMsgs.UP_AUTHORIZE_MSG_STARTUP_1701;

    public JT809Msg_1701_UpAuthorizeMsgStartup() {
        setDataType(DATA_TYPE);
    }

    private String platformId;
    private String authorizeCode1;
    private String authorizeCode2;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getAuthorizeCode1() {
        return authorizeCode1;
    }

    public void setAuthorizeCode1(String authorizeCode1) {
        this.authorizeCode1 = authorizeCode1;
    }

    public String getAuthorizeCode2() {
        return authorizeCode2;
    }

    public void setAuthorizeCode2(String authorizeCode2) {
        this.authorizeCode2 = authorizeCode2;
    }

    @Override
    public String toString() {
        return "JT809Msg_1701_UpAuthorizeMsgStartup{" +
                "platformId='" + platformId + '\'' +
                ", authorizeCode1='" + authorizeCode1 + '\'' +
                ", authorizeCode2='" + authorizeCode2 + '\'' +
                "} " + super.toString();
    }
}
