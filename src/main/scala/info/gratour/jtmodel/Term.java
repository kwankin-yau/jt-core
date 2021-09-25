/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

import info.gratour.common.CommonMessages;
import info.gratour.common.types.EpochMillis;
import info.gratour.jtcommon.JTMessages;

import java.time.LocalDate;
import java.util.Arrays;

public class Term {

    public static final int TERM_TYPE__2G = 0;
    public static final int TERM_TYPE__1078 = 1;
    public static final int TERM_TYPE__ADAS = 2;

    public static boolean termTypSupport1078(int typ) {
        switch (typ) {
            case TERM_TYPE__1078:
            case TERM_TYPE__ADAS:
                return true;

            default:
                return false;
        }
    }

    private String simNo;
    private String actualSimNo;
    private String authCode;
    private int typ;
    private long grpId;
    private String grpName;
    private String factoryId;
    private String factory;
    private String model;
    private String terminalId;
    private String imei;
    private Long vehId;
    private String plateNo;
    private Integer plateColor;
    private int avChan;
    private int[] avChanIds;
    private boolean avAttrsReady;
    private EpochMillis avAttrsUpdateTm;
    private Short audioCodec;
    private Short audioChan;
    private Short audioSampleRate;
    private Short audioBitDepth;
    private Integer audioFrameSz;
    private Boolean audioOutputEnabled;
    private Short videoCodec;
    private Short maxAudioChan;
    private Short maxVideoChan;
    private LocalDate termInstallDate;
    private boolean disableAudio;
    private boolean termRegToGov;
    private EpochMillis createTime;
    private long createUser;
    private String createUserName;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getActualSimNo() {
        return actualSimNo;
    }

    public void setActualSimNo(String actualSimNo) {
        this.actualSimNo = actualSimNo;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public static String typText(int typ) {
        String key = "termTyp." + typ;
        if (JTMessages.BUNDLE().containsKey(key)) {
            return JTMessages.BUNDLE().getString(key);
        } else
            return CommonMessages.UNKNOWN() + "(" + typ + ")";
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

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
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

    public String getPlateNoDefEmpty() {
        if (plateNo == null)
            return "";
        else
            return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public int getAvChan() {
        return avChan;
    }

    public void setAvChan(int avChan) {
        this.avChan = avChan;
    }

    public int[] getAvChanIds() {
        return avChanIds;
    }

    public void setAvChanIds(int[] avChanIds) {
        this.avChanIds = avChanIds;
    }

    public void updateAvChan() {
        if (avChanIds == null)
            avChan = 0;
        else
            avChan = avChanIds.length;
    }

    public boolean isAvAttrsReady() {
        return avAttrsReady;
    }

    public void setAvAttrsReady(boolean avAttrsReady) {
        this.avAttrsReady = avAttrsReady;
    }

    public EpochMillis getAvAttrsUpdateTm() {
        return avAttrsUpdateTm;
    }

    public void setAvAttrsUpdateTm(EpochMillis avAttrsUpdateTm) {
        this.avAttrsUpdateTm = avAttrsUpdateTm;
    }

    public Short getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(Short audioCodec) {
        this.audioCodec = audioCodec;
    }

    public Short getAudioChan() {
        return audioChan;
    }

    public void setAudioChan(Short audioChan) {
        this.audioChan = audioChan;
    }

    public Short getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(Short audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public Short getAudioBitDepth() {
        return audioBitDepth;
    }

    public void setAudioBitDepth(Short audioBitDepth) {
        this.audioBitDepth = audioBitDepth;
    }

    public Integer getAudioFrameSz() {
        return audioFrameSz;
    }

    public void setAudioFrameSz(Integer audioFrameSz) {
        this.audioFrameSz = audioFrameSz;
    }

    public Boolean getAudioOutputEnabled() {
        return audioOutputEnabled;
    }

    public void setAudioOutputEnabled(Boolean audioOutputEnabled) {
        this.audioOutputEnabled = audioOutputEnabled;
    }

    public Short getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(Short videoCodec) {
        this.videoCodec = videoCodec;
    }

    public Short getMaxAudioChan() {
        return maxAudioChan;
    }

    public void setMaxAudioChan(Short maxAudioChan) {
        this.maxAudioChan = maxAudioChan;
    }

    public Short getMaxVideoChan() {
        return maxVideoChan;
    }

    public void setMaxVideoChan(Short maxVideoChan) {
        this.maxVideoChan = maxVideoChan;
    }

    public LocalDate getTermInstallDate() {
        return termInstallDate;
    }

    public void setTermInstallDate(LocalDate termInstallDate) {
        this.termInstallDate = termInstallDate;
    }

    public boolean isDisableAudio() {
        return disableAudio;
    }

    public void setDisableAudio(boolean disableAudio) {
        this.disableAudio = disableAudio;
    }

    public boolean isTermRegToGov() {
        return termRegToGov;
    }

    public void setTermRegToGov(boolean termRegToGov) {
        this.termRegToGov = termRegToGov;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
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
        final StringBuilder sb = new StringBuilder("Term{");
        sb.append("simNo='").append(simNo).append('\'');
        sb.append(", actualSimNo='").append(actualSimNo).append('\'');
        sb.append(", authCode='").append(authCode).append('\'');
        sb.append(", typ=").append(typ);
        sb.append(", grpId=").append(grpId);
        sb.append(", grpName='").append(grpName).append('\'');
        sb.append(", factoryId='").append(factoryId).append('\'');
        sb.append(", factory='").append(factory).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", terminalId='").append(terminalId).append('\'');
        sb.append(", imei='").append(imei).append('\'');
        sb.append(", vehId=").append(vehId);
        sb.append(", plateNo='").append(plateNo).append('\'');
        sb.append(", plateColor=").append(plateColor);
        sb.append(", avChan=").append(avChan);
        sb.append(", avChanIds=").append(Arrays.toString(avChanIds));
        sb.append(", avAttrsReady=").append(avAttrsReady);
        sb.append(", avAttrsUpdateTm=").append(avAttrsUpdateTm);
        sb.append(", audioCodec=").append(audioCodec);
        sb.append(", audioChan=").append(audioChan);
        sb.append(", audioSampleRate=").append(audioSampleRate);
        sb.append(", audioBitDepth=").append(audioBitDepth);
        sb.append(", audioFrameSz=").append(audioFrameSz);
        sb.append(", audioOutputEnabled=").append(audioOutputEnabled);
        sb.append(", videoCodec=").append(videoCodec);
        sb.append(", maxAudioChan=").append(maxAudioChan);
        sb.append(", maxVideoChan=").append(maxVideoChan);
        sb.append(", termInstallDate=").append(termInstallDate);
        sb.append(", disableAudio=").append(disableAudio);
        sb.append(", termRegToGov=").append(termRegToGov);
        sb.append(", createTime=").append(createTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", createUserName='").append(createUserName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
