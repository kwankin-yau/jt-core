package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;

@JT809DataType(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_MONITOR_VEHICLE_ACK_1501)
public class JT809Msg_1501_UpCtrlMsgMonitorVehicleAck extends JT809UpCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_MONITOR_VEHICLE_ACK_1501;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 1;

    public JT809Msg_1501_UpCtrlMsgMonitorVehicleAck() {
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
        return "JT809Msg_1501_UpCtrlMsgMonitorVehicleAck{" +
                "result=" + result +
                "} " + super.toString();
    }
}
