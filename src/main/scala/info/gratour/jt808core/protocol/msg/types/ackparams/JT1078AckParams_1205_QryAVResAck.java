/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams;

import info.gratour.jt808core.protocol.JT1078MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT1078AVRes;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT1078MsgConsts.QRY_AV_RES_ACK_1205)
public class JT1078AckParams_1205_QryAVResAck implements JT808AckParams {

    private JT1078AVRes[] resList;

    public JT1078AVRes[] getResList() {
        return resList;
    }

    public void setResList(JT1078AVRes[] resList) {
        this.resList = resList;
    }

    @Override
    public String toString() {
        return "JT1078AckParams_1205_QryAVResAck{" +
                "resList=" + Arrays.toString(resList) +
                '}';
    }
}
