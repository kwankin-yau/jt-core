/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class MarkInspectAckSentReq {

    private String id;
    private String targetId;
    private long ackTm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public long getAckTm() {
        return ackTm;
    }

    public void setAckTm(long ackTm) {
        this.ackTm = ackTm;
    }

    @Override
    public String toString() {
        return "MarkInspectAckSentReq{" +
                "id='" + id + '\'' +
                ", targetId='" + targetId + '\'' +
                ", ackTm=" + ackTm +
                '}';
    }
}
