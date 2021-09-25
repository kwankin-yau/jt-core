/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

public class JT808VTDR_PulseFactor_04 implements JT808VTDRDataBlock {

    private String dateTime;
    private int factor;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getFactor() {
        return factor;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    @Override
    public String toString() {
        return "JT808VTDR_PulseFactor{" +
                "dateTime='" + dateTime + '\'' +
                ", factor=" + factor +
                '}';
    }
}
