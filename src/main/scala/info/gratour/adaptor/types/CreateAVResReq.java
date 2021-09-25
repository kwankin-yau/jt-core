/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class CreateAVResReq {

    private String simNo;
    private String uploadCmdId;
    private Long uploadCmdTm;
    private byte chan;
    private long startTm;
    private long endTm;
    private int almSt808;
    private int almSt1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private Long nominalFileSz;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getUploadCmdId() {
        return uploadCmdId;
    }

    public void setUploadCmdId(String uploadCmdId) {
        this.uploadCmdId = uploadCmdId;
    }

    public Long getUploadCmdTm() {
        return uploadCmdTm;
    }

    public void setUploadCmdTm(Long uploadCmdTm) {
        this.uploadCmdTm = uploadCmdTm;
    }

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public long getStartTm() {
        return startTm;
    }

    public void setStartTm(long startTm) {
        this.startTm = startTm;
    }

    public long getEndTm() {
        return endTm;
    }

    public void setEndTm(long endTm) {
        this.endTm = endTm;
    }

    public int getAlmSt808() {
        return almSt808;
    }

    public void setAlmSt808(int almSt808) {
        this.almSt808 = almSt808;
    }

    public int getAlmSt1078() {
        return almSt1078;
    }

    public void setAlmSt1078(int almSt1078) {
        this.almSt1078 = almSt1078;
    }

    public byte getMediaTyp() {
        return mediaTyp;
    }

    public void setMediaTyp(byte mediaTyp) {
        this.mediaTyp = mediaTyp;
    }

    public byte getCodeStrm() {
        return codeStrm;
    }

    public void setCodeStrm(byte codeStrm) {
        this.codeStrm = codeStrm;
    }

    public byte getStgTyp() {
        return stgTyp;
    }

    public void setStgTyp(byte stgTyp) {
        this.stgTyp = stgTyp;
    }

    public Long getNominalFileSz() {
        return nominalFileSz;
    }

    public void setNominalFileSz(Long nominalFileSz) {
        this.nominalFileSz = nominalFileSz;
    }

    @Override
    public String toString() {
        return "CreateAVResReq{" +
                "simNo='" + simNo + '\'' +
                ", uploadCmdId='" + uploadCmdId + '\'' +
                ", uploadCmdTm=" + uploadCmdTm +
                ", chan=" + chan +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", almSt808=" + almSt808 +
                ", almSt1078=" + almSt1078 +
                ", mediaTyp=" + mediaTyp +
                ", codeStrm=" + codeStrm +
                ", stgTyp=" + stgTyp +
                ", nominalFileSz=" + nominalFileSz +
                '}';
    }
}
