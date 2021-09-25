/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.term;

public class UpdateTermAVAttrsReq {

    private String simNo;
    private long avAttrsUpdateTm;
    private byte audioCodec;
    private byte audioChan;
    private byte audioSampleRate;
    private byte audioBitDepth;
    private int audioFrameSz;
    private boolean audioOutputEnabled;
    private byte videoCodec;
    private byte maxAudioChan;
    private byte maxVideoChan;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getAvAttrsUpdateTm() {
        return avAttrsUpdateTm;
    }

    public void setAvAttrsUpdateTm(long avAttrsUpdateTm) {
        this.avAttrsUpdateTm = avAttrsUpdateTm;
    }

    public byte getAudioCodec() {
        return audioCodec;
    }

    public void setAudioCodec(byte audioCodec) {
        this.audioCodec = audioCodec;
    }

    public byte getAudioChan() {
        return audioChan;
    }

    public void setAudioChan(byte audioChan) {
        this.audioChan = audioChan;
    }

    public byte getAudioSampleRate() {
        return audioSampleRate;
    }

    public void setAudioSampleRate(byte audioSampleRate) {
        this.audioSampleRate = audioSampleRate;
    }

    public byte getAudioBitDepth() {
        return audioBitDepth;
    }

    public void setAudioBitDepth(byte audioBitDepth) {
        this.audioBitDepth = audioBitDepth;
    }

    public int getAudioFrameSz() {
        return audioFrameSz;
    }

    public void setAudioFrameSz(int audioFrameSz) {
        this.audioFrameSz = audioFrameSz;
    }

    public boolean isAudioOutputEnabled() {
        return audioOutputEnabled;
    }

    public void setAudioOutputEnabled(boolean audioOutputEnabled) {
        this.audioOutputEnabled = audioOutputEnabled;
    }

    public byte getVideoCodec() {
        return videoCodec;
    }

    public void setVideoCodec(byte videoCodec) {
        this.videoCodec = videoCodec;
    }

    public byte getMaxAudioChan() {
        return maxAudioChan;
    }

    public void setMaxAudioChan(byte maxAudioChan) {
        this.maxAudioChan = maxAudioChan;
    }

    public byte getMaxVideoChan() {
        return maxVideoChan;
    }

    public void setMaxVideoChan(byte maxVideoChan) {
        this.maxVideoChan = maxVideoChan;
    }

    @Override
    public String toString() {
        return "UpdateTermAVAttrsReq{" +
                "simNo='" + simNo + '\'' +
                ", avAttrsUpdateTm=" + avAttrsUpdateTm +
                ", audioCodec=" + audioCodec +
                ", audioChan=" + audioChan +
                ", audioSampleRate=" + audioSampleRate +
                ", audioBitDepth=" + audioBitDepth +
                ", audioFrameSz=" + audioFrameSz +
                ", audioOutputEnabled=" + audioOutputEnabled +
                ", videoCodec=" + videoCodec +
                ", maxAudioChan=" + maxAudioChan +
                ", maxVideoChan=" + maxVideoChan +
                '}';
    }
}
