/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto.gateway;

public class TermConnState implements GatewayRespObject {

    private String simNo;
    private Long connAt;
    private Long lastActive;
    private Long trkCnt;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public Long getConnAt() {
        return connAt;
    }

    public void setConnAt(Long connAt) {
        this.connAt = connAt;
    }

    public long connAtDefault0() {
        if (connAt != null)
            return connAt;
        else
            return 0L;
    }

    public Long getLastActive() {
        return lastActive;
    }

    public void setLastActive(Long lastActive) {
        this.lastActive = lastActive;
    }

    public long lastActiveDefault0() {
        if (lastActive != null)
            return lastActive;
        else
            return 0L;
    }

    public Long getTrkCnt() {
        return trkCnt;
    }

    public void setTrkCnt(Long trkCnt) {
        this.trkCnt = trkCnt;
    }

    public long trkCntDefault0() {
        if (trkCnt != null)
            return trkCnt;
        else
            return 0L;
    }

    @Override
    public String toString() {
        return "TermConnState{" +
                "simNo='" + simNo + '\'' +
                ", connAt=" + connAt +
                ", lastActive=" + lastActive +
                ", trkCnt=" + trkCnt +
                '}';
    }
}
