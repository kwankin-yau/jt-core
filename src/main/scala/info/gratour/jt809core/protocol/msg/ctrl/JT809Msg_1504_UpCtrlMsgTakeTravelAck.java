package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TAKE_TRAVEL_ACK_1504)
public class JT809Msg_1504_UpCtrlMsgTakeTravelAck extends JT809UpCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TAKE_TRAVEL_ACK_1504;

    public JT809Msg_1504_UpCtrlMsgTakeTravelAck() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject ackParamsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("commandType", commandType);
        o.addProperty("travelDataInfo", travelDataInfo);
        return o;
    }

    private byte commandType;
    private String travelDataInfo;

    public byte getCommandType() {
        return commandType;
    }

    public void setCommandType(byte commandType) {
        this.commandType = commandType;
    }

    public String getTravelDataInfo() {
        return travelDataInfo;
    }

    public void setTravelDataInfo(String travelDataInfo) {
        this.travelDataInfo = travelDataInfo;
    }

    @Override
    public String toString() {
        return "JT809Msg_1504_UpCtrlMsgTakeTravelAck{" +
                "commandType=" + commandType +
                ", travelDataInfo='" + travelDataInfo + '\'' +
                "} " + super.toString();
    }
}
