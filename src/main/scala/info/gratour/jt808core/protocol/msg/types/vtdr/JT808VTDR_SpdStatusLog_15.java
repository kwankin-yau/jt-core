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

public class JT808VTDR_SpdStatusLog_15 implements JT808VTDRDataBlock {
    private List<VTDR_LogRec> logRecords;

    public List<VTDR_LogRec> getLogRecords() {
        return logRecords;
    }

    public void setLogRecords(List<VTDR_LogRec> logRecords) {
        this.logRecords = logRecords;
    }

    public void addLogRecord(VTDR_LogRec logRec) {
        if (this.logRecords == null)
            this.logRecords = new ArrayList<>();

        this.logRecords.add(logRec);
    }

    @Override
    public String toString() {
        return "JT808VTDR_SpdStatusLog{" +
                "logRecords=" + logRecords +
                '}';
    }
}
