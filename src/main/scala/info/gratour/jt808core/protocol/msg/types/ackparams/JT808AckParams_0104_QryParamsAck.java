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

import java.util.HashMap;
import java.util.Map;

@JTMsgId(JT808MsgConsts.QRY_PARAMS_ACK_0104)
public class JT808AckParams_0104_QryParamsAck implements JT808AckParams {



    private Map<String, Object> params = new HashMap<>();

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0104_QryParamsAck{" +
                "params=" + params +
                '}';
    }
}
