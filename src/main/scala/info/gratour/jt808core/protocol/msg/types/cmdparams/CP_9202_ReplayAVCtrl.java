/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.REPLAY_AV_CTRL_9202)
public class CP_9202_ReplayAVCtrl implements JT808CmdParams {

    public static final int CTRL__RESUME = 0;
    public static final int CTRL__PAUSE = 1;
    public static final int CTRL__STOP = 2;
    public static final int CTRL__FORWARD = 3;
    public static final int CTRL__BACKWARD = 4;
    public static final int CTRL__SEEK = 5;
    public static final int CTRL__K_FRAME_PLAY = 6;

    private byte channel;
    private int ctrl;
    private Byte factor;
    private Long time;
    private String serverId;


    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public int getCtrl() {
        return ctrl;
    }

    public void setCtrl(int ctrl) {
        this.ctrl = ctrl;
    }

    public Byte getFactor() {
        return factor;
    }

    public void setFactor(Byte factor) {
        this.factor = factor;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "CP_9202_ReplayAVCtrl{" +
                "channel=" + channel +
                ", ctrl=" + ctrl +
                ", factor=" + factor +
                ", time=" + time +
                ", serverId='" + serverId + '\'' +
                '}';
    }
}
