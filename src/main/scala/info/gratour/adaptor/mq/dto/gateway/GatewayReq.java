/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto.gateway;

public class GatewayReq {

    public static final String TYP__conn_state = "conn_state";

    private String reqId;
    private String typ;
    private String gw;
    private GatewayReqParams gatewayReqParams;

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

    public String getGw() {
        return gw;
    }

    public void setGw(String gw) {
        this.gw = gw;
    }

    public GatewayReqParams getGatewayReqParams() {
        return gatewayReqParams;
    }

    public void setGatewayReqParams(GatewayReqParams gatewayReqParams) {
        this.gatewayReqParams = gatewayReqParams;
    }

    @Override
    public String toString() {
        return "GatewayReq{" +
                "reqId='" + reqId + '\'' +
                ", typ='" + typ + '\'' +
                ", gw='" + gw + '\'' +
                ", gatewayReqParams=" + gatewayReqParams +
                '}';
    }
}
