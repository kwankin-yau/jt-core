/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808RectRegion;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_RECT_REGION_8602)
public class CP_8602_SetRectRegion implements JT808CmdParams {

    private byte action;
    private JT808RectRegion[] regions;

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public JT808RectRegion[] getRegions() {
        return regions;
    }

    public void setRegions(JT808RectRegion[] regions) {
        this.regions = regions;
    }

    @Override
    public String toString() {
        return "CP_8602_SetRectRegion{" +
                "action=" + action +
                ", regions=" + Arrays.toString(regions) +
                '}';
    }
}
