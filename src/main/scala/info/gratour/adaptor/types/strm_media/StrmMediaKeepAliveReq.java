/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

import java.util.Arrays;

public class StrmMediaKeepAliveReq {

    private String[] reqIds;
    private ServerHint strmServerHint;

    public String[] getReqIds() {
        return reqIds;
    }

    public void setReqIds(String[] reqIds) {
        this.reqIds = reqIds;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    @Override
    public String toString() {
        return "StrmMediaKeepAliveReq{" +
                "reqIds=" + Arrays.toString(reqIds) +
                ", strmServerHint=" + strmServerHint +
                '}';
    }
}
