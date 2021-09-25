/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;


import info.gratour.common.types.EpochMillis;
import info.gratour.jtmodel.trk.Trk;

public class MultiMedia {

    public static final short TYP__IMAGE = 0;
    public static final short TYP__AUDIO = 1;
    public static final short TYP__VIDEO = 2;

    public static final short FMT__JPEG = 0;
    public static final short FMT__TIF = 1;
    public static final short FMT__MP3 = 2;
    public static final short FMT__WAV = 3;
    public static final short FMT__WMV = 4;

    private long id;
    private String simNo;
    private long grpId;
    private EpochMillis gpsTm;
    private EpochMillis recvTm;
    private long mediaId;
    private short typ;
    private short fmt;
    private short evtCode;
    private short chan;
    private Trk trk;
    private String path;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public EpochMillis getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(EpochMillis recvTm) {
        this.recvTm = recvTm;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
    }

    public EpochMillis getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(EpochMillis gpsTm) {
        this.gpsTm = gpsTm;
    }

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public short getFmt() {
        return fmt;
    }

    public void setFmt(short fmt) {
        this.fmt = fmt;
    }

    public short getEvtCode() {
        return evtCode;
    }

    public void setEvtCode(short evtCode) {
        this.evtCode = evtCode;
    }

    public short getChan() {
        return chan;
    }

    public void setChan(short chan) {
        this.chan = chan;
    }

    public Trk getTrk() {
        return trk;
    }

    public void setTrk(Trk trk) {
        this.trk = trk;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MultiMedia{" +
                "id=" + id +
                ", simNo='" + simNo + '\'' +
                ", grpId=" + grpId +
                ", gpsTm=" + gpsTm +
                ", recvTm=" + recvTm +
                ", mediaId=" + mediaId +
                ", typ=" + typ +
                ", fmt=" + fmt +
                ", evtCode=" + evtCode +
                ", chan=" + chan +
                ", trk=" + trk +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
