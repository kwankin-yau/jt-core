package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_HISGNSSDATA_REQ_1209)
public class JT809Msg_1209_UpExgMsgApplyHisGnssDataReq extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_APPLY_HISGNSSDATA_REQ_1209;

    public JT809Msg_1209_UpExgMsgApplyHisGnssDataReq() {
        setDataType(DATA_TYPE);
    }

    private long startTime;
    private long endTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "JT809Msg_1209_UpExgMsgApplyHisGnssDataReq{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
