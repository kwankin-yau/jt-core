package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REPORT_DRIVER_INFO_ACK_120A)
public class JT809Msg_120A_UpExgMsgReportDriverInfoAck extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REPORT_DRIVER_INFO_ACK_120A;

    public JT809Msg_120A_UpExgMsgReportDriverInfoAck() {
        setDataType(DATA_TYPE);
    }

    private String driverName;
    private String driverId;
    private String licence;
    private String orgName;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        return "JT809Msg_120A_UpExgMsgReportDriverInfoAck{" +
                "driverName='" + driverName + '\'' +
                ", driverId='" + driverId + '\'' +
                ", licence='" + licence + '\'' +
                ", orgName='" + orgName + '\'' +
                "} " + super.toString();
    }
}
