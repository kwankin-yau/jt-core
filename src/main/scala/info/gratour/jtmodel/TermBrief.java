/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

import java.util.Arrays;

public class TermBrief {

    private String simNo;
    private String authCode;
    private int typ;
    private long grpId;
    private Long vehId;
    private String plateNo;
    private Integer plateColor;
    private int avChan;
    private int[] avChanIds;
    private boolean avAttrsReady;
    private Short audioCodec;
    private Short audioChan;
    private Short audioSampleRate;
    private Short audioBitDepth;
    private Boolean audioOutputEnabled;
    private Short videoCodec;
    private boolean disableAudio;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
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

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
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

    public boolean isAvAttrsReady() {
        return avAttrsReady;
    }

    public void setAvAttrsReady(boolean avAttrsReady) {
        this.avAttrsReady = avAttrsReady;
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

    public boolean isDisableAudio() {
        return disableAudio;
    }

    public void setDisableAudio(boolean disableAudio) {
        this.disableAudio = disableAudio;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TermBrief{");
        sb.append("simNo='").append(simNo).append('\'');
        sb.append(", authCode='").append(authCode).append('\'');
        sb.append(", typ=").append(typ);
        sb.append(", grpId=").append(grpId);
        sb.append(", vehId=").append(vehId);
        sb.append(", plateNo='").append(plateNo).append('\'');
        sb.append(", plateColor=").append(plateColor);
        sb.append(", avChan=").append(avChan);
        sb.append(", avChanIds=").append(Arrays.toString(avChanIds));
        sb.append(", avAttrsReady=").append(avAttrsReady);
        sb.append(", audioCodec=").append(audioCodec);
        sb.append(", audioChan=").append(audioChan);
        sb.append(", audioSampleRate=").append(audioSampleRate);
        sb.append(", audioBitDepth=").append(audioBitDepth);
        sb.append(", audioOutputEnabled=").append(audioOutputEnabled);
        sb.append(", videoCodec=").append(videoCodec);
        sb.append(", disableAudio=").append(disableAudio);
        sb.append('}');
        return sb.toString();
    }
}
