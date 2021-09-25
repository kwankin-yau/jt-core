/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

public class AlmProcRpt {

    private String id;
    private String plateNo;
    private int plateColor;
    private byte result;
    private byte meth;
    private String oprName;
    private String oprCorpName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public byte getMeth() {
        return meth;
    }

    public void setMeth(byte meth) {
        this.meth = meth;
    }

    public String getOprName() {
        return oprName;
    }

    public void setOprName(String oprName) {
        this.oprName = oprName;
    }

    public String getOprCorpName() {
        return oprCorpName;
    }

    public void setOprCorpName(String oprCorpName) {
        this.oprCorpName = oprCorpName;
    }

    @Override
    public String toString() {
        return "AlmProcRpt{" +
                "id='" + id + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", result=" + result +
                ", meth=" + meth +
                ", oprName='" + oprName + '\'' +
                ", oprCorpName='" + oprCorpName + '\'' +
                '}';
    }
}
