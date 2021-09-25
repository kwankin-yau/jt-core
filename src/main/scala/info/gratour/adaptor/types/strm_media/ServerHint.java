/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

public class ServerHint {

    public static final String STRM_SERVER_ID__TEST = "test";

    private String strmServerId;

    public String getStrmServerId() {
        return strmServerId;
    }

    public void setStrmServerId(String strmServerId) {
        this.strmServerId = strmServerId;
    }

    @Override
    public String toString() {
        return "StrmServerHint{" +
                "strmServerId='" + strmServerId + '\'' +
                '}';
    }
}
