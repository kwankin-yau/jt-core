/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govsubmit;

import info.gratour.common.types.EpochMillis;

public class SafetyTermInstall {

    private String plateNo;
    private short plateColor;
    private String factory;
    private String termModel;
    private String termId;
    private EpochMillis instTm;
    private String instCorp;
    private String contacts;
    private String tel;
    private boolean compliance;

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(short plateColor) {
        this.plateColor = plateColor;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTermModel() {
        return termModel;
    }

    public void setTermModel(String termModel) {
        this.termModel = termModel;
    }

    public String getTermId() {
        return termId;
    }

    public void setTermId(String termId) {
        this.termId = termId;
    }

    public EpochMillis getInstTm() {
        return instTm;
    }

    public void setInstTm(EpochMillis instTm) {
        this.instTm = instTm;
    }

    public String getInstCorp() {
        return instCorp;
    }

    public void setInstCorp(String instCorp) {
        this.instCorp = instCorp;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public boolean isCompliance() {
        return compliance;
    }

    public void setCompliance(boolean compliance) {
        this.compliance = compliance;
    }

    @Override
    public String toString() {
        return "SafetyTermInstall{" +
                "plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", factory='" + factory + '\'' +
                ", termModel='" + termModel + '\'' +
                ", termId='" + termId + '\'' +
                ", instTm=" + instTm +
                ", instCorp='" + instCorp + '\'' +
                ", contacts='" + contacts + '\'' +
                ", tel='" + tel + '\'' +
                ", compliance=" + compliance +
                '}';
    }
}
