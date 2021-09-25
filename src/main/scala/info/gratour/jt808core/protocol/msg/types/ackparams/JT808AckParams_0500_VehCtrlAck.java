/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtmodel.trk.Trk;

@JTMsgId(JT808MsgConsts.VEH_CTRL_ACK_0500)
public class JT808AckParams_0500_VehCtrlAck implements JT808AckParams {

    private Trk trk;

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0500_VehCtrlAck{" +
                "trk=" + trk +
                '}';
    }
}
