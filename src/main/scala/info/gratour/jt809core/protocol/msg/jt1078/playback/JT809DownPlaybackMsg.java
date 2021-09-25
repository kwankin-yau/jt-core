/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.playback;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_9A00)
public class JT809DownPlaybackMsg extends JT809PlaybackMsg {

    public static final int MSG_ID = JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_9A00;

    public JT809DownPlaybackMsg() {
        setMsgId(MSG_ID);
    }

}
