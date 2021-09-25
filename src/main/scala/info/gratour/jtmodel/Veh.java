/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

import info.gratour.common.types.EpochMillis;

import java.time.LocalDate;

public class Veh {

    private long vehId;
    private String plateNo;
    private int plateColor;
    private String simNo;
    private LocalDate termInstallDate;
    private long grpId;
    private String grpName;

    private String vehTypeCode;
    private String vehTypeName;

    private String transTypeCode;
    private String transTypeName;

    private String nationalityCode;
    private String nationalityName;

    private String bizScopeCode;
    private String bizScopeName;

    private long corpId;
    private String corpName;

    private String traction;
    private String trailerPlateNo;

    private String rtpn;
    private String operatorName;
    private String operatorPhoneNo;

    private String rtoln;

    private String vehModel;

    private String approvedTonnage;
    private String cargoName;
    private String cargoTonnage;
    private String transOriginName;
    private String transDestName;
    private String bizAreaName;
    private String departStName;
    private String destStName;


    private String vehOwnerId;
    private String vehOwnerName;
    private String vehOwnerTel;

    private String bizKindCode;
    private String bizKindName;
    private String bizKindExtraData;

    private String note;

    private EpochMillis createTime;
    private long createUser;
    private String createUserName;

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

    public LocalDate getTermInstallDate() {
        return termInstallDate;
    }

    public void setTermInstallDate(LocalDate termInstallDate) {
        this.termInstallDate = termInstallDate;
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

    public String getVehTypeCode() {
        return vehTypeCode;
    }

    public void setVehTypeCode(String vehTypeCode) {
        this.vehTypeCode = vehTypeCode;
    }

    public String getVehTypeName() {
        return vehTypeName;
    }

    public void setVehTypeName(String vehTypeName) {
        this.vehTypeName = vehTypeName;
    }

    public String getTransTypeCode() {
        return transTypeCode;
    }

    public void setTransTypeCode(String transTypeCode) {
        this.transTypeCode = transTypeCode;
    }

    public String getTransTypeName() {
        return transTypeName;
    }

    public void setTransTypeName(String transTypeName) {
        this.transTypeName = transTypeName;
    }

    public String getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(String nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public String getNationalityName() {
        return nationalityName;
    }

    public void setNationalityName(String nationalityName) {
        this.nationalityName = nationalityName;
    }

    public String getBizScopeCode() {
        return bizScopeCode;
    }

    public void setBizScopeCode(String bizScopeCode) {
        this.bizScopeCode = bizScopeCode;
    }

    public String getBizScopeName() {
        return bizScopeName;
    }

    public void setBizScopeName(String bizScopeName) {
        this.bizScopeName = bizScopeName;
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

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public String getTrailerPlateNo() {
        return trailerPlateNo;
    }

    public void setTrailerPlateNo(String trailerPlateNo) {
        this.trailerPlateNo = trailerPlateNo;
    }

    public String getRtpn() {
        return rtpn;
    }

    public void setRtpn(String rtpn) {
        this.rtpn = rtpn;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getOperatorPhoneNo() {
        return operatorPhoneNo;
    }

    public void setOperatorPhoneNo(String operatorPhoneNo) {
        this.operatorPhoneNo = operatorPhoneNo;
    }

    public String getRtoln() {
        return rtoln;
    }

    public void setRtoln(String rtoln) {
        this.rtoln = rtoln;
    }

    public String getVehModel() {
        return vehModel;
    }

    public void setVehModel(String vehModel) {
        this.vehModel = vehModel;
    }

    public String getApprovedTonnage() {
        return approvedTonnage;
    }

    public void setApprovedTonnage(String approvedTonnage) {
        this.approvedTonnage = approvedTonnage;
    }

    public String getCargoName() {
        return cargoName;
    }

    public void setCargoName(String cargoName) {
        this.cargoName = cargoName;
    }

    public String getCargoTonnage() {
        return cargoTonnage;
    }

    public void setCargoTonnage(String cargoTonnage) {
        this.cargoTonnage = cargoTonnage;
    }

    public String getTransOriginName() {
        return transOriginName;
    }

    public void setTransOriginName(String transOriginName) {
        this.transOriginName = transOriginName;
    }

    public String getTransDestName() {
        return transDestName;
    }

    public void setTransDestName(String transDestName) {
        this.transDestName = transDestName;
    }

    public String getBizAreaName() {
        return bizAreaName;
    }

    public void setBizAreaName(String bizAreaName) {
        this.bizAreaName = bizAreaName;
    }

    public String getDepartStName() {
        return departStName;
    }

    public void setDepartStName(String departStName) {
        this.departStName = departStName;
    }

    public String getDestStName() {
        return destStName;
    }

    public void setDestStName(String destStName) {
        this.destStName = destStName;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public EpochMillis getCreateTime() {
        return createTime;
    }

    public void setCreateTime(EpochMillis createTime) {
        this.createTime = createTime;
    }

    public long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(long createUser) {
        this.createUser = createUser;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    @Override
    public String toString() {
        return "Veh{" +
                "vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", simNo='" + simNo + '\'' +
                ", termInstallDate=" + termInstallDate +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", vehTypeCode='" + vehTypeCode + '\'' +
                ", vehTypeName='" + vehTypeName + '\'' +
                ", transTypeCode='" + transTypeCode + '\'' +
                ", transTypeName='" + transTypeName + '\'' +
                ", nationalityCode='" + nationalityCode + '\'' +
                ", nationalityName='" + nationalityName + '\'' +
                ", bizScopeCode='" + bizScopeCode + '\'' +
                ", bizScopeName='" + bizScopeName + '\'' +
                ", corpId=" + corpId +
                ", corpName='" + corpName + '\'' +
                ", traction='" + traction + '\'' +
                ", trailerPlateNo='" + trailerPlateNo + '\'' +
                ", rtpn='" + rtpn + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", operatorPhoneNo='" + operatorPhoneNo + '\'' +
                ", rtoln='" + rtoln + '\'' +
                ", vehModel='" + vehModel + '\'' +
                ", approvedTonnage='" + approvedTonnage + '\'' +
                ", cargoName='" + cargoName + '\'' +
                ", cargoTonnage='" + cargoTonnage + '\'' +
                ", transOriginName='" + transOriginName + '\'' +
                ", transDestName='" + transDestName + '\'' +
                ", bizAreaName='" + bizAreaName + '\'' +
                ", departStName='" + departStName + '\'' +
                ", destStName='" + destStName + '\'' +
                ", vehOwnerId='" + vehOwnerId + '\'' +
                ", vehOwnerName='" + vehOwnerName + '\'' +
                ", vehOwnerTel='" + vehOwnerTel + '\'' +
                ", bizKindCode='" + bizKindCode + '\'' +
                ", bizKindName='" + bizKindName + '\'' +
                ", bizKindExtraData='" + bizKindExtraData + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", createUser=" + createUser +
                ", createUserName='" + createUserName + '\'' +
                '}';
    }
}
