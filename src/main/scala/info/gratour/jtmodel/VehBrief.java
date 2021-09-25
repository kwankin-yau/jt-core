/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

import java.util.Arrays;

public class VehBrief {
    private long vehId;
    private String plateNo;
    private int plateColor;
    private String simNo;
    private long grpId;
    private String grpName;
    private long corpId;
    private String corpName;
    private Integer termTyp;
    private Integer avChan;
    private int[] avChanIds;
    private String termFactoryId;
    private String termFactory;
    private String termModel;
    private String terminalId;
    private String termImei;
    private String bizKindCode;
    private String bizKindName;
    private String bizKindExtraData;
    private boolean disableAudio;
    private String vehOwnerId;
    private String vehOwnerName;
    private String vehOwnerTel;
    private boolean vehRegToGov;
    private Boolean termRegToGov;

    public long getVehId() {
        return vehId;
    }

    public void setVehId(long vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public long getCorpId() {
        return corpId;
    }

    public void setCorpId(long corpId) {
        this.corpId = corpId;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public Integer getTermTyp() {
        return termTyp;
    }

    public void setTermTyp(Integer termTyp) {
        this.termTyp = termTyp;
    }

    public Integer getAvChan() {
        return avChan;
    }

    public void setAvChan(Integer avChan) {
        this.avChan = avChan;
    }

    public int[] getAvChanIds() {
        return avChanIds;
    }

    public void setAvChanIds(int[] avChanIds) {
        this.avChanIds = avChanIds;
    }

    public String getTermFactoryId() {
        return termFactoryId;
    }

    public void setTermFactoryId(String termFactoryId) {
        this.termFactoryId = termFactoryId;
    }

    public String getTermFactory() {
        return termFactory;
    }

    public void setTermFactory(String termFactory) {
        this.termFactory = termFactory;
    }

    public String getTermModel() {
        return termModel;
    }

    public void setTermModel(String termModel) {
        this.termModel = termModel;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTermImei() {
        return termImei;
    }

    public void setTermImei(String termImei) {
        this.termImei = termImei;
    }

    public String getBizKindCode() {
        return bizKindCode;
    }

    public void setBizKindCode(String bizKindCode) {
        this.bizKindCode = bizKindCode;
    }

    public String getBizKindName() {
        return bizKindName;
    }

    public void setBizKindName(String bizKindName) {
        this.bizKindName = bizKindName;
    }

    public String getBizKindExtraData() {
        return bizKindExtraData;
    }

    public void setBizKindExtraData(String bizKindExtraData) {
        this.bizKindExtraData = bizKindExtraData;
    }

    public boolean isDisableAudio() {
        return disableAudio;
    }

    public void setDisableAudio(boolean disableAudio) {
        this.disableAudio = disableAudio;
    }

    public String getVehOwnerId() {
        return vehOwnerId;
    }

    public void setVehOwnerId(String vehOwnerId) {
        this.vehOwnerId = vehOwnerId;
    }

    public String getVehOwnerName() {
        return vehOwnerName;
    }

    public void setVehOwnerName(String vehOwnerName) {
        this.vehOwnerName = vehOwnerName;
    }

    public String getVehOwnerTel() {
        return vehOwnerTel;
    }

    public void setVehOwnerTel(String vehOwnerTel) {
        this.vehOwnerTel = vehOwnerTel;
    }

    public boolean isVehRegToGov() {
        return vehRegToGov;
    }

    public void setVehRegToGov(boolean vehRegToGov) {
        this.vehRegToGov = vehRegToGov;
    }

    public Boolean getTermRegToGov() {
        return termRegToGov;
    }

    public void setTermRegToGov(Boolean termRegToGov) {
        this.termRegToGov = termRegToGov;
    }

    public boolean getTermRegToGovDef() {
        if (termRegToGov != null)
            return termRegToGov;
        else
            return false;
    }

    @Override
    public String toString() {
        return "VehBrief{" +
                "vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", simNo='" + simNo + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", corpId=" + corpId +
                ", corpName='" + corpName + '\'' +
                ", termTyp=" + termTyp +
                ", avChan=" + avChan +
                ", avChanIds=" + Arrays.toString(avChanIds) +
                ", termFactoryId='" + termFactoryId + '\'' +
                ", termFactory='" + termFactory + '\'' +
                ", termModel='" + termModel + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", termImei='" + termImei + '\'' +
                ", bizKindCode='" + bizKindCode + '\'' +
                ", bizKindName='" + bizKindName + '\'' +
                ", bizKindExtraData='" + bizKindExtraData + '\'' +
                ", disableAudio=" + disableAudio +
                ", vehOwnerId='" + vehOwnerId + '\'' +
                ", vehOwnerName='" + vehOwnerName + '\'' +
                ", vehOwnerTel='" + vehOwnerTel + '\'' +
                ", vehRegToGov=" + vehRegToGov +
                ", termRegToGov=" + termRegToGov +
                '}';
    }
}
