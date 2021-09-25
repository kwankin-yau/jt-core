package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_EMERGENCY_MONITORING_ACK_1505)
public class JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck extends JT809UpCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_EMERGENCY_MONITORING_ACK_1505;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__VEH_NOT_FOUND = 1;
    public static final byte RESULT__FAILED_OTHER_REASON = 2;

    public JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject ackParamsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("result", result);
        return o;
    }

    private byte result;

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809Msg_1505_UpCtrlMsgEmergencyMonitoringAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
