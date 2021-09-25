package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_TAKE_EWAYBILL_ACK_120B)
public class JT809Msg_120B_UpExgMsgTakeEWayBillAck extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_TAKE_EWAYBILL_ACK_120B;

    public JT809Msg_120B_UpExgMsgTakeEWayBillAck() {
        setDataType(DATA_TYPE);
    }

    private String eWayBillInfo;

    public String getEWayBillInfo() {
        return eWayBillInfo;
    }

    public void setEWayBillInfo(String eWayBillInfo) {
        this.eWayBillInfo = eWayBillInfo;
    }

    @Override
    public String toString() {
        return "JT809Msg_120B_UpExgMsgTakeEWayBillAck{" +
                "eWayBillInfo='" + eWayBillInfo + '\'' +
                "} " + super.toString();
    }
}
