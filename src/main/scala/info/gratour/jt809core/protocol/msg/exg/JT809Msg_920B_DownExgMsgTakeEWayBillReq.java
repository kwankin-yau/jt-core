package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_TAKE_EWAYBILL_REQ_920B)
public class JT809Msg_920B_DownExgMsgTakeEWayBillReq extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_TAKE_EWAYBILL_REQ_920B;

    public JT809Msg_920B_DownExgMsgTakeEWayBillReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public String toString() {
        return "JT809Msg_920B_DownExgMsgTakeEWayBillReq{} " + super.toString();
    }
}
