/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.vtdr.JT808VTDRDataBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.VTDR_SET_PARAMS_8701)
public class CP_8701_VTDRSetParams implements JT808CmdParams {

    private byte cmd;
    private JT808VTDRDataBlock dataBlock;

    public byte getCmd() {
        return cmd;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public JT808VTDRDataBlock getDataBlock() {
        return dataBlock;
    }

    public void setDataBlock(JT808VTDRDataBlock dataBlock) {
        this.dataBlock = dataBlock;
    }

    @Override
    public String toString() {
        return "CP_8701_VTDRSetParams{" +
                "cmd=" + cmd +
                ", dataBlock=" + dataBlock +
                '}';
    }
}
