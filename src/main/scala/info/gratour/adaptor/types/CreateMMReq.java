/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;


import info.gratour.common.types.EpochMillis;
import info.gratour.jtmodel.trk.Trk;

public class CreateMMReq {

    private String simNo;
    private EpochMillis recvTm;
    private EpochMillis gpsTm;
    private long mediaId;
    private short typ;
    private short fmt;
    private short evtCode;
    private short chan;
    private Trk trk;
    private String data;

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public EpochMillis getRecvTm() {
        return recvTm;
    }

    public void setRecvTm(EpochMillis recvTm) {
        this.recvTm = recvTm;
    }

    public EpochMillis getGpsTm() {
        return gpsTm;
    }

    public void setGpsTm(EpochMillis gpsTm) {
        this.gpsTm = gpsTm;
    }

    public long getMediaId() {
        return mediaId;
    }

    public void setMediaId(long mediaId) {
        this.mediaId = mediaId;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CreateMMReq{" +
                "simNo='" + simNo + '\'' +
                ", recvTm=" + recvTm +
                ", gpsTm=" + gpsTm +
                ", mediaId=" + mediaId +
                ", typ=" + typ +
                ", fmt=" + fmt +
                ", evtCode=" + evtCode +
                ", chan=" + chan +
                ", trk=" + trk +
                ", data='" + data + '\'' +
                '}';
    }
}
