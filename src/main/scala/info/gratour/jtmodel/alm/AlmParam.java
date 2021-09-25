/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

public class AlmParam {

    private String typ;
    private boolean disabled;
    private boolean stat;
    private boolean sendVoice;
    private String voiceText;
    private boolean notifyClnt;

    private boolean capture;
    private short captureChanMask;
    private boolean liveVidMon;
    private short liveVidMonChanMask;

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isSendVoice() {
        return sendVoice;
    }

    public void setSendVoice(boolean sendVoice) {
        this.sendVoice = sendVoice;
    }

    public String getVoiceText() {
        return voiceText;
    }

    public void setVoiceText(String voiceText) {
        this.voiceText = voiceText;
    }

    public boolean isNotifyClnt() {
        return notifyClnt;
    }

    public void setNotifyClnt(boolean notifyClnt) {
        this.notifyClnt = notifyClnt;
    }

    public boolean isStat() {
        return stat;
    }

    public void setStat(boolean stat) {
        this.stat = stat;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    public short getCaptureChanMask() {
        return captureChanMask;
    }

    public void setCaptureChanMask(short captureChanMask) {
        this.captureChanMask = captureChanMask;
    }

    public boolean isLiveVidMon() {
        return liveVidMon;
    }

    public void setLiveVidMon(boolean liveVidMon) {
        this.liveVidMon = liveVidMon;
    }

    public short getLiveVidMonChanMask() {
        return liveVidMonChanMask;
    }

    public void setLiveVidMonChanMask(short liveVidMonChanMask) {
        this.liveVidMonChanMask = liveVidMonChanMask;
    }

    @Override
    public String toString() {
        return "AlmParam{" +
                "typ='" + typ + '\'' +
                ", disabled=" + disabled +
                ", stat=" + stat +
                ", sendVoice=" + sendVoice +
                ", voiceText='" + voiceText + '\'' +
                ", notifyClnt=" + notifyClnt +
                ", capture=" + capture +
                ", captureChanMask=" + captureChanMask +
                ", liveVidMon=" + liveVidMon +
                ", liveVidMonChanMask=" + liveVidMonChanMask +
                '}';
    }
}
