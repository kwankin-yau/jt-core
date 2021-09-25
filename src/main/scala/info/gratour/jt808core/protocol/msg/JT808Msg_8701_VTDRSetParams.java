/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg;

import info.gratour.jt808core.protocol.JT808FrameHeader;
import info.gratour.jt808core.protocol.JT808Msg;
import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8701_VTDRSetParams;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.VTDR_SET_PARAMS_8701)
public class JT808Msg_8701_VTDRSetParams extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.VTDR_SET_PARAMS_8701;

    public JT808Msg_8701_VTDRSetParams() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8701_VTDRSetParams(JT808FrameHeader header) {
        super(header);
    }


    private CP_8701_VTDRSetParams params;

    public CP_8701_VTDRSetParams getParams() {
        return params;
    }

    public void setParams(CP_8701_VTDRSetParams params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8701_VTDRSetParams{" +
                "params=" + params +
                "} " + super.toString();
    }
}
