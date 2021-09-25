/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govissue;

import info.gratour.common.types.EpochMillis;

public class AlmSupervise {

    public static final byte LVL__EMERGENCY = 0;
    public static final byte LVL__DEFAULT = 1;

    private String id;
    private EpochMillis tm;
    private Long vehId;

    private String plateNo;
    private short plateColor;
    private Long grpId;
    private Byte almSrc;
    private String almTyp;
    private EpochMillis almTm;
    private long almRecId;
    private int supervisionId;
    private EpochMillis deadline;
    private byte lvl;
    private String supervisor;
    private String tel;
    private String email;
    private Byte result;
    private EpochMillis lastProcTm;
    private Byte updateKind;

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

    public Long getVehId() {
        return vehId;
    }

    public void setVehId(Long vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(short plateColor) {
        this.plateColor = plateColor;
    }

    public Long getGrpId() {
        return grpId;
    }

    public void setGrpId(Long grpId) {
        this.grpId = grpId;
    }

    public Byte getAlmSrc() {
        return almSrc;
    }

    public void setAlmSrc(Byte almSrc) {
        this.almSrc = almSrc;
    }

    public String getAlmTyp() {
        return almTyp;
    }

    public void setAlmTyp(String almTyp) {
        this.almTyp = almTyp;
    }

    public EpochMillis getAlmTm() {
        return almTm;
    }

    public void setAlmTm(EpochMillis almTm) {
        this.almTm = almTm;
    }

    public long getAlmRecId() {
        return almRecId;
    }

    public void setAlmRecId(long almRecId) {
        this.almRecId = almRecId;
    }

    public int getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(int supervisionId) {
        this.supervisionId = supervisionId;
    }

    public EpochMillis getDeadline() {
        return deadline;
    }

    public void setDeadline(EpochMillis deadline) {
        this.deadline = deadline;
    }

    public byte getLvl() {
        return lvl;
    }

    public void setLvl(byte lvl) {
        this.lvl = lvl;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getResult() {
        return result;
    }

    public void setResult(Byte result) {
        this.result = result;
    }

    public EpochMillis getLastProcTm() {
        return lastProcTm;
    }

    public void setLastProcTm(EpochMillis lastProcTm) {
        this.lastProcTm = lastProcTm;
    }

    public Byte getUpdateKind() {
        return updateKind;
    }

    public void setUpdateKind(Byte updateKind) {
        this.updateKind = updateKind;
    }

    @Override
    public String toString() {
        return "AlmSupervise{" +
                "id='" + id + '\'' +
                ", tm=" + tm +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", almSrc=" + almSrc +
                ", almTyp='" + almTyp + '\'' +
                ", almTm=" + almTm +
                ", almRecId=" + almRecId +
                ", supervisionId=" + supervisionId +
                ", deadline=" + deadline +
                ", lvl=" + lvl +
                ", supervisor='" + supervisor + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", result=" + result +
                ", lastProcTm=" + lastProcTm +
                ", updateKind=" + updateKind +
                '}';
    }
}
