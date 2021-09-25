/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govissue;

import info.gratour.common.types.EpochMillis;

import java.util.ArrayList;
import java.util.List;

public class GovInspect {

    public static final int TARGET_TYP__PLATFORM = 1;
    public static final int TARGET_TYP__SPECIFIED_CORP = 2;
    public static final int TARGET_TYP__ALL_CORP = 3;

    public static boolean isValidTargetType(int targetTyp) {
        return targetTyp >= TARGET_TYP__PLATFORM && targetTyp <= TARGET_TYP__ALL_CORP;
    }

    private String id;
    private EpochMillis tm;
    private int targetTyp;
    private String targetId;
    private int answerTm;
    private int infoId;
    private String content;
    private List<GovInspectAck> acks;

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

    public int getAnswerTm() {
        return answerTm;
    }

    public void setAnswerTm(int answerTm) {
        this.answerTm = answerTm;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<GovInspectAck> getAcks() {
        return acks;
    }

    public void setAcks(List<GovInspectAck> acks) {
        this.acks = acks;
    }

    public void addAck(GovInspectAck ack) {
        if (acks == null)
            acks = new ArrayList<>();

        acks.add(ack);
    }

    @Override
    public String toString() {
        return "GovInspect{" +
                "id='" + id + '\'' +
                ", tm=" + tm +
                ", targetTyp=" + targetTyp +
                ", targetId='" + targetId + '\'' +
                ", answerTm=" + answerTm +
                ", infoId=" + infoId +
                ", content='" + content + '\'' +
                ", acks=" + acks +
                '}';
    }
}
