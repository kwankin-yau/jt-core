/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

import info.gratour.common.types.EpochMillis;

public class AVRes {

    public static final byte STATE__REQUESTED = 1;
    public static final byte STATE__UPLOADING = 2;
    public static final byte STATE__UPLOADED = 3;
    public static final byte STATE__FAILED = 4;
    public static final byte STATE__CANCELED = 5;

    public static final int MEDIA_TYPE__AV = 0;
    public static final int MEDIA_TYPE__A = 1;
    public static final int MEDIA_TYPE__V = 2;

    public static final int CODE_STREAM__PRIMARY = 1;
    public static final int CODE_STREAM__SUB = 2;

    public static final int STORAGE__PRIMARY = 1;
    public static final int STORAGE__BACKUP = 2;

    private String avResId;
    private String uploadCmdId;
    private String simNo;
    private Long vehId;
    private String plateNo;
    private Integer plateColor;
    private byte chan;
    private EpochMillis startTm;
    private EpochMillis endTm;
    private int almSt808;
    private int almSt1078;
    private byte mediaTyp;
    private byte codeStrm;
    private byte stgTyp;
    private long nominalFileSz;
    private Long fileSz;
    private byte st;
    private EpochMillis reqTm;
    private String path;
    private String fileName;
    private Long uploadTm;
    private String url;

    public String getAvResId() {
        return avResId;
    }

    public void setAvResId(String avResId) {
        this.avResId = avResId;
    }

    public String getUploadCmdId() {
        return uploadCmdId;
    }

    public void setUploadCmdId(String uploadCmdId) {
        this.uploadCmdId = uploadCmdId;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
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

    public byte getChan() {
        return chan;
    }

    public void setChan(byte chan) {
        this.chan = chan;
    }

    public EpochMillis getStartTm() {
        return startTm;
    }

    public void setStartTm(EpochMillis startTm) {
        this.startTm = startTm;
    }

    public EpochMillis getEndTm() {
        return endTm;
    }

    public void setEndTm(EpochMillis endTm) {
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

    public boolean mediaTypIncludeAudio() {
        return mediaTyp == MEDIA_TYPE__A || mediaTyp == MEDIA_TYPE__AV;
    }

    public boolean mediaTypIncludeVideo() {
        return mediaTyp == MEDIA_TYPE__AV || mediaTyp == MEDIA_TYPE__V;
    }

    public boolean mediaTypIsAV() {
        return mediaTyp == MEDIA_TYPE__AV;
    }

    public boolean mediaTypIncludeAudioOrVideo() {
        switch (mediaTyp) {
            case MEDIA_TYPE__A:
            case MEDIA_TYPE__AV:
            case MEDIA_TYPE__V:
                return true;

            default:
                return false;
        }
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

    public long getNominalFileSz() {
        return nominalFileSz;
    }

    public void setNominalFileSz(long nominalFileSz) {
        this.nominalFileSz = nominalFileSz;
    }

    public Long getFileSz() {
        return fileSz;
    }

    public void setFileSz(Long fileSz) {
        this.fileSz = fileSz;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public byte getSt() {
        return st;
    }

    public void setSt(byte st) {
        this.st = st;
    }

    public EpochMillis getReqTm() {
        return reqTm;
    }

    public void setReqTm(EpochMillis reqTm) {
        this.reqTm = reqTm;
    }

    public static String signature(String simNo, int chan, long startTm, long endTm, int mediaTyp, int codeStrm, int stgTyp) {
        return simNo + "_" + chan + "_" + startTm + "_" + endTm + "_" + mediaTyp + "_" + codeStrm + "_" + stgTyp;
    }

    @Override
    public String toString() {
        return "AVRes{" +
                "avResId='" + avResId + '\'' +
                ", uploadCmdId='" + uploadCmdId + '\'' +
                ", simNo='" + simNo + '\'' +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", chan=" + chan +
                ", startTm=" + startTm +
                ", endTm=" + endTm +
                ", almSt808=" + almSt808 +
                ", almSt1078=" + almSt1078 +
                ", mediaTyp=" + mediaTyp +
                ", codeStrm=" + codeStrm +
                ", stgTyp=" + stgTyp +
                ", nominalFileSz=" + nominalFileSz +
                ", fileSz=" + fileSz +
                ", st=" + st +
                ", reqTm=" + reqTm +
                ", path='" + path + '\'' +
                ", fileName='" + fileName + '\'' +
                ", uploadTm=" + uploadTm +
                ", url='" + url + '\'' +
                '}';
    }
}
