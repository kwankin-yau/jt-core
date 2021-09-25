/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class UpdateAVResReq {

    private String simNo;
    private byte chan;
    private long startTm;
    private long endTm;
    private int almSt808;
    private int almSt1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private byte st;

    // the following fields only valid when st == 3
    private Long fileSz;
    private String path;
    private String fileName;
    private Long uploadTm;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
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

    public Long getFileSz() {
        return fileSz;
    }

    public void setFileSz(Long fileSz) {
        this.fileSz = fileSz;
    }

    public byte getSt() {
        return st;
    }

    public void setSt(byte st) {
        this.st = st;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Long getUploadTm() {
        return uploadTm;
    }

    public void setUploadTm(Long uploadTm) {
        this.uploadTm = uploadTm;
    }

    @Override
    public String toString() {
        return "UpdateAVResReq{" +
                "simNo='" + simNo + '\'' +
                ", chan=" + chan +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", almSt808=" + almSt808 +
                ", almSt1078=" + almSt1078 +
                ", mediaTyp=" + mediaTyp +
                ", codeStrm=" + codeStrm +
                ", stgTyp=" + stgTyp +
                ", st=" + st +
                ", fileSz=" + fileSz +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTm=" + uploadTm +
                '}';
    }
}
