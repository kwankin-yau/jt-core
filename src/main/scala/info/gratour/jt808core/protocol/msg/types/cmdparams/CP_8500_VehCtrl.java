/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.VEH_CTRL_8500)
public class CP_8500_VehCtrl implements JT808CmdParams {

    private byte flags;

    public byte getFlags() {
        return flags;
    }

    public void setFlags(byte flags) {
        this.flags = flags;
    }

    @Override
    public String toString() {
        return "CP_8500_VehCtrl{" +
                "flags=" + flags +
                '}';
    }
}
