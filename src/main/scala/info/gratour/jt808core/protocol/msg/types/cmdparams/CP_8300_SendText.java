/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.common.utils.BitUtils;
import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT808MsgConsts.SEND_TEXT_8300)
public class CP_8300_SendText implements JT808CmdParams {


    public static final int BIT__EMERGE = 0;
    public static final int BIT__DISPLAY = 2;
    public static final int BIT__TTS = 3;
    public static final int BIT__ADVERT = 4;
    public static final int BIT__CAN_FAULT = 5;

    public static final int BIT_MASK__EMERGE = 1 << 0;
    public static final int BIT_MASK__DISPLAY = 1 << 2;
    public static final int BIT_MASK__TTS = 1 << 3;
    public static final int BIT_MASK__ADVERT = 1 << 4;
    public static final int BIT_MASK__CAN_FAULT = 1 << 5;

    private byte opts;
    private String text;

    public byte getOpts() {
        return opts;
    }

    public void setOpts(byte opts) {
        this.opts = opts;
    }

    public void setOpts(int opts) {
        this.opts = (byte) opts;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public boolean isEmerge() {
        return BitUtils.test(opts, BIT__EMERGE);
    }

    public void setEmerge(boolean emerge) {
        if (emerge)
            opts = (byte) BitUtils.set(opts, BIT__EMERGE);
        else
            opts = (byte) BitUtils.clear(opts, BIT__EMERGE);
    }



    @Override
    public String toString() {
        return "CP_8300_SendText{" +
                "opts=" + opts +
                ", text='" + text + '\'' +
                '}';
    }
}
