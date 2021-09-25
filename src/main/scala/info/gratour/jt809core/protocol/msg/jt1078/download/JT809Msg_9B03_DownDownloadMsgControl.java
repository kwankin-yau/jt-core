/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.download;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.VideoDownloadMsgs.DOWN_DOWNLOAD_MSG_CONTROL_9B03)
public class JT809Msg_9B03_DownDownloadMsgControl extends JT809DownDownloadMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoDownloadMsgs.DOWN_DOWNLOAD_MSG_CONTROL_9B03;

    public static final byte TYP__PAUSE = 0;
    public static final byte TYP__RESUME = 1;
    public static final byte TYP__CANCEL = 2;

    public JT809Msg_9B03_DownDownloadMsgControl() {
        setDataType(DATA_TYPE);
    }

    private int sessionId;
    private byte typ;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    @Override
    public String toString() {
        return "JT809_9B03_DownDownloadMsgControl{" +
                "sessionId=" + sessionId +
                ", typ=" + typ +
                "} " + super.toString();
    }
}
