/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.filelist;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.VideoFileListMsgs.DOWN_FILELIST_MSG_9900)
public class JT809DownFileListMsg extends JT809FileListMsg {

    public static final int MSG_ID = JT809MsgConsts.VideoFileListMsgs.DOWN_FILELIST_MSG_9900;

    public JT809DownFileListMsg() {
        setMsgId(MSG_ID);
    }
}
