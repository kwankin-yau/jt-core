/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;

public class VTDR_LogRec {

    private byte spdState;
    private String startTime;
    private String endTime;
    private List<VTDR_SpdLogEntry> spdLogEntries;

    public byte getSpdState() {
        return spdState;
    }

    public void setSpdState(byte spdState) {
        this.spdState = spdState;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public List<VTDR_SpdLogEntry> getSpdLogEntries() {
        return spdLogEntries;
    }

    public void setSpdLogEntries(List<VTDR_SpdLogEntry> spdLogEntries) {
        this.spdLogEntries = spdLogEntries;
    }

    public void addSpdLogEntry(VTDR_SpdLogEntry entry) {
        if (this.spdLogEntries == null)
            this.spdLogEntries = new ArrayList<>();

        this.spdLogEntries.add(entry);
    }

    @Override
    public String toString() {
        return "VTDR_LogRec{" +
                "spdState=" + spdState +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", spdLogEntries=" + spdLogEntries +
                '}';
    }
}
