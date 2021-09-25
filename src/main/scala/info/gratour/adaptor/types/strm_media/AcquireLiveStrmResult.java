/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

public class AcquireLiveStrmResult {

    private String reqId;
    private Boolean ctrl;
    private String playUrl;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public Boolean getCtrl() {
        return ctrl;
    }

    public void setCtrl(Boolean ctrl) {
        this.ctrl = ctrl;
    }

    public boolean ctrlDef() {
        if (ctrl != null)
            return ctrl;
        else
            return false;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    @Override
    public String toString() {
        return "AcquireLiveStrmResult{" +
                "reqId='" + reqId + '\'' +
                ", ctrl=" + ctrl +
                ", playUrl='" + playUrl + '\'' +
                '}';
    }
}
