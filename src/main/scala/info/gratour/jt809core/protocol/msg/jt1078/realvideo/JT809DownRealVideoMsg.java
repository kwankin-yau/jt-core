/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.realvideo;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_9800)
public class JT809DownRealVideoMsg extends JT809RealVideoMsg {

    public static final int MSG_ID = JT809MsgConsts.RealVideoMsgs.DOWN_REALVIDEO_MSG_9800;

    public JT809DownRealVideoMsg() {
        setMsgId(MSG_ID);
    }
}
