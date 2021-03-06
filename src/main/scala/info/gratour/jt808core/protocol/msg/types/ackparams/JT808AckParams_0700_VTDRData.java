/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.vtdr.JT808VTDRDataBlock;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.VTDR_DATA_0700)
public class JT808AckParams_0700_VTDRData implements JT808AckParams {

    private byte cmd;
    private JT808VTDRDataBlock dataBlock;
    private String raw;

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

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0700_VTDRData{" +
                "cmd=" + cmd +
                ", dataBlock=" + dataBlock +
                ", raw='" + raw + '\'' +
                '}';
    }
}
