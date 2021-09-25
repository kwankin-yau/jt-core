/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.mq.dto;

import com.google.gson.reflect.TypeToken;
import info.gratour.adaptor.mq.dto.types.MQEventAddt;

import java.lang.reflect.Type;

public class Event {

    public static final Type TYPE = new TypeToken<Event>(){}.getType();

    private String msgId;
    private String simNo;
    private long recvTm;
    private MQEventAddt addt;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(long recvTm) {
        this.recvTm = recvTm;
    }

    public MQEventAddt getAddt() {
        return addt;
    }

    public void setAddt(MQEventAddt addt) {
        this.addt = addt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "msgId='" + msgId + '\'' +
                ", simNo='" + simNo + '\'' +
                ", recvTm=" + recvTm +
                ", addt=" + addt +
                '}';
    }
}
