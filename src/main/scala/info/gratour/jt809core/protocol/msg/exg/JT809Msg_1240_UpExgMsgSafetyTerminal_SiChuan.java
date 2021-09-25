/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_SAFETY_TERMINAL_1240__SICHUAN)
public class JT809Msg_1240_UpExgMsgSafetyTerminal_SiChuan extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_SAFETY_TERMINAL_1240__SICHUAN;

    public JT809Msg_1240_UpExgMsgSafetyTerminal_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private String platformId;
    private String producer;
    private String terminalModel;
    private String terminalId;
    private long installTime;
    private String installCompany;
    private String contacts;
    private String tel;
    private boolean compliance;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public long getInstallTime() {
        return installTime;
    }

    public void setInstallTime(long installTime) {
        this.installTime = installTime;
    }

    public String getInstallCompany() {
        return installCompany;
    }

    public void setInstallCompany(String installCompany) {
        this.installCompany = installCompany;
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
        return "JT809Msg_1240_UpExgMsgSafetyTerminal_SiChuan{" +
                "platformId='" + platformId + '\'' +
                ", producer='" + producer + '\'' +
                ", terminalModel='" + terminalModel + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", installTime=" + installTime +
                ", installCompany='" + installCompany + '\'' +
                ", contacts='" + contacts + '\'' +
                ", tel='" + tel + '\'' +
                ", compliance=" + compliance +
                "} " + super.toString();
    }
}
