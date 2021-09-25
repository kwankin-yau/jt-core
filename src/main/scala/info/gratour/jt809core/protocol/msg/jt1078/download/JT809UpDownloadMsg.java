/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.download;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_1B00)
public class JT809UpDownloadMsg extends JT809DownloadMsg {

    public static final int MSG_ID = JT809MsgConsts.VideoDownloadMsgs.UP_DOWNLOAD_MSG_1B00;

    public JT809UpDownloadMsg() {
        setMsgId(MSG_ID);
    }

}
