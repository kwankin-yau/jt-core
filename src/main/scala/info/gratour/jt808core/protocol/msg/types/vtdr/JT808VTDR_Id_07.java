/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

public class JT808VTDR_Id_07 implements JT808VTDRDataBlock {
    private String ccc;
    private String model;
    private String prodYear;
    private String prodMonth;
    private String prodDay;
    private int serialNum;

    public String getCcc() {
        return ccc;
    }

    public void setCcc(String ccc) {
        this.ccc = ccc;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getProdYear() {
        return prodYear;
    }

    public void setProdYear(String prodYear) {
        this.prodYear = prodYear;
    }

    public String getProdMonth() {
        return prodMonth;
    }

    public void setProdMonth(String prodMonth) {
        this.prodMonth = prodMonth;
    }

    public String getProdDay() {
        return prodDay;
    }

    public void setProdDay(String prodDay) {
        this.prodDay = prodDay;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    @Override
    public String toString() {
        return "JT808VTDR_Id_07{" +
                "ccc='" + ccc + '\'' +
                ", model='" + model + '\'' +
                ", prodYear='" + prodYear + '\'' +
                ", prodMonth='" + prodMonth + '\'' +
                ", prodDay='" + prodDay + '\'' +
                ", serialNum=" + serialNum +
                '}';
    }
}
