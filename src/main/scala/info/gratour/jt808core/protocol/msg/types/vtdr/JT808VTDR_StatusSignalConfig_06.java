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

public class JT808VTDR_StatusSignalConfig_06 implements JT808VTDRDataBlock {

    private String dateTime;
    private List<VTDR_Status> status;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public List<VTDR_Status> getStatus() {
        return status;
    }

    public void setStatus(List<VTDR_Status> status) {
        this.status = status;
    }

    public boolean hasStatus() {
        return status != null && !status.isEmpty();
    }

    public void addStatus(VTDR_Status status) {
        if (this.status == null)
            this.status = new ArrayList<>();

        this.status.add(status);
    }

    @Override
    public String toString() {
        return "JT808VTDR_StatusSignalConfig{" +
                "dateTime='" + dateTime + '\'' +
                ", status=" + status +
                '}';
    }
}
