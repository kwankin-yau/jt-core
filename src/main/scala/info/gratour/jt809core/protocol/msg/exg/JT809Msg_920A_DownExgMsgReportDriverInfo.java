package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_REPORT_DRIVER_INFO_920A)
public class JT809Msg_920A_DownExgMsgReportDriverInfo extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_REPORT_DRIVER_INFO_920A;

    public JT809Msg_920A_DownExgMsgReportDriverInfo() {
        setDataType(DATA_TYPE);
    }

    @Override
    public String toString() {
        return "JT809Msg_920A_DownExgMsgReportDriverInfo{} " + super.toString();
    }
}
