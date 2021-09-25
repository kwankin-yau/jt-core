/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types;

public class JT808InquestCandidateItem {

    private short candidateId;
    private String candidate;

    public short getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(short candidateId) {
        this.candidateId = candidateId;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    @Override
    public String toString() {
        return "JT808MsgInquestCandidateItem{" +
                "candidateId=" + candidateId +
                ", candidate='" + candidate + '\'' +
                '}';
    }
}
