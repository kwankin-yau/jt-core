/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govissue;

import info.gratour.common.types.EpochMillis;

public class GovInspectAck {

    private String id;
    private EpochMillis tm;
    private int targetTyp;
    private String targetId;
    private int infoId;
    private EpochMillis ackTm;
    private long answerUser;
    private String answer;
    private EpochMillis answerSentTm;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EpochMillis getTm() {
        return tm;
    }

    public void setTm(EpochMillis tm) {
        this.tm = tm;
    }

    public int getTargetTyp() {
        return targetTyp;
    }

    public void setTargetTyp(int targetTyp) {
        this.targetTyp = targetTyp;
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public EpochMillis getAckTm() {
        return ackTm;
    }

    public void setAckTm(EpochMillis ackTm) {
        this.ackTm = ackTm;
    }

    public long getAnswerUser() {
        return answerUser;
    }

    public void setAnswerUser(long answerUser) {
        this.answerUser = answerUser;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public EpochMillis getAnswerSentTm() {
        return answerSentTm;
    }

    public void setAnswerSentTm(EpochMillis answerSentTm) {
        this.answerSentTm = answerSentTm;
    }

    @Override
    public String toString() {
        return "GovInspectAck{" +
                "id='" + id + '\'' +
                ", tm=" + tm +
                ", targetTyp=" + targetTyp +
                ", targetId='" + targetId + '\'' +
                ", infoId=" + infoId +
                ", ackTm=" + ackTm +
                ", answerUser=" + answerUser +
                ", answer='" + answer + '\'' +
                ", answerSentTm=" + answerSentTm +
                '}';
    }
}
