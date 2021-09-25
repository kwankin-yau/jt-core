/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808CircleRegion;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_CIRCLE_REGION_8600)
public class CP_8600_SetCircleRegion implements JT808CmdParams {

    private byte action;
    private JT808CircleRegion[] regions;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808CircleRegion[] getRegions() {
        return regions;
    }

    public void setRegions(JT808CircleRegion[] regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "CP_8600_SetCircleRegion{" +
                "action=" + action +
                ", regions=" + Arrays.toString(regions) +
                '}';
    }
}
