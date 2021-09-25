/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto.gateway;

import java.util.ArrayList;
import java.util.List;

public class GatewayResp {

    private String reqId;
    private String typ;
    private List<GatewayRespObject> resp;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public List<GatewayRespObject> getResp() {
        return resp;
    }

    public void setResp(List<GatewayRespObject> resp) {
        this.resp = resp;
    }

    public void addRespObject(GatewayRespObject obj) {
        if (resp == null)
            resp = new ArrayList<>();

        resp.add(obj);
    }


    @Override
    public String toString() {
        return "GatewayResp{" +
                "reqId='" + reqId + '\'' +
                ", typ='" + typ + '\'' +
                ", resp=" + resp +
                '}';
    }
}
