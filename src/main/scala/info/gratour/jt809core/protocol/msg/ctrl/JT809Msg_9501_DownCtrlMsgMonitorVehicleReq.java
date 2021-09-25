package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.common.Consts;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_MONITOR_VEHICLE_REQ_9501)
public class JT809Msg_9501_DownCtrlMsgMonitorVehicleReq extends JT809DownCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_MONITOR_VEHICLE_REQ_9501;

    public JT809Msg_9501_DownCtrlMsgMonitorVehicleReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject paramsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("monitorTel", monitorTel);
        return o;
    }

    private String monitorTel;

    public String getMonitorTel() {
        return monitorTel;
    }

    public void setMonitorTel(String monitorTel) {
        this.monitorTel = monitorTel;
    }

    @Override
    public String toString() {
        return "JT809Msg_9501_DownCtrlMsgMonitorVehicleReq{" +
                "monitorTel='" + monitorTel + '\'' +
                "} " + super.toString();
    }
}
