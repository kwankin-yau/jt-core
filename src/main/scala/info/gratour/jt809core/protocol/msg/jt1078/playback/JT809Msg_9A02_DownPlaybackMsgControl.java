/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.jt1078.playback;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import org.omg.CORBA.PUBLIC_MEMBER;

@JT809DataType(JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_CONTROL_9A02)
public class JT809Msg_9A02_DownPlaybackMsgControl extends JT809DownPlaybackMsg {

    public static final int DATA_TYPE = JT809MsgConsts.VideoPlaybackMsgs.DOWN_PLAYBACK_MSG_CONTROL_9A02;

    public static final byte CONTROL_TYPE__NORMAL = 0;
    public static final byte CONTROL_TYPE__PAUSE = 1;
    public static final byte CONTROL_TYPE__STOP = 2;
    public static final byte CONTROL_TYPE__FAST_FORWARD = 3;
    public static final byte CONTROL_TYPE__FAST_BACKWARD = 4;
    public static final byte CONTROL_TYPE__SEEK = 5;
    public static final byte CONTROL_TYPE__KEY_FRAME_PLAYING = 6;

    public static final byte FAST_TIME__NOT_USED = 0;
    public static final byte FAST_TIME__1X = 1;
    public static final byte FAST_TIME__2X = 2;
    public static final byte FAST_TIME__4X = 3;
    public static final byte FAST_TIME__8X = 4;
    public static final byte FAST_TIME__16X = 5;

    public JT809Msg_9A02_DownPlaybackMsgControl() {
        setDataType(DATA_TYPE);
    }

    private byte controlType;
    private byte fastTime;
    private long dateTime;

    public byte getControlType() {
        return controlType;
    }

    public void setControlType(byte controlType) {
        this.controlType = controlType;
    }

    public byte getFastTime() {
        return fastTime;
    }

    public void setFastTime(byte fastTime) {
        this.fastTime = fastTime;
    }

    public long getDateTime() {
        return dateTime;
    }

    public void setDateTime(long dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "JT809_9A02_DownPlaybackMsgControl{" +
                "controlType=" + controlType +
                ", fastTime=" + fastTime +
                ", dateTime=" + dateTime +
                "} " + super.toString();
    }
}
