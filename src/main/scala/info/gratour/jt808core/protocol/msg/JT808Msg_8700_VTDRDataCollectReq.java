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
import info.gratour.jt808core.protocol.msg.types.cmdparams.CP_8700_VTDRDataCollectReq;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700)
public class JT808Msg_8700_VTDRDataCollectReq extends JT808Msg {

    public static final int MSG_ID = JT808MsgConsts.VTDR_DATA_COLLECT_REQ_8700;

    public JT808Msg_8700_VTDRDataCollectReq() {
        setMsgId(MSG_ID);
    }

    public JT808Msg_8700_VTDRDataCollectReq(JT808FrameHeader header) {
        super(header);
    }

    private CP_8700_VTDRDataCollectReq params;

    public CP_8700_VTDRDataCollectReq getParams() {
        return params;
    }

    public void setParams(CP_8700_VTDRDataCollectReq params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808Msg_8700_VTDRDataCollectReq{" +
                "params=" + params +
                "} " + super.toString();
    }
}
