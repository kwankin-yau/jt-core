/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto.gateway;

import java.util.Arrays;

public class GatewayReqParams_ConnState implements GatewayReqParams {
    private String[] simNos;

    public String[] getSimNos() {
        return simNos;
    }

    public void setSimNos(String[] simNos) {
        this.simNos = simNos;
    }

    @Override
    public String toString() {
        return "GatewayReqParams_ConnState{" +
                "simNos=" + Arrays.toString(simNos) +
                '}';
    }
}
