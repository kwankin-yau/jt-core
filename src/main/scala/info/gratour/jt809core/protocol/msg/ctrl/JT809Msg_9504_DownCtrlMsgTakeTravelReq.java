package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TAKE_TRAVEL_REQ_9504)
public class JT809Msg_9504_DownCtrlMsgTakeTravelReq extends JT809DownCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TAKE_TRAVEL_REQ_9504;

    public JT809Msg_9504_DownCtrlMsgTakeTravelReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject paramsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("commandType", commandType);
        return o;
    }

    private byte commandType;

    public byte getCommandType() {
        return commandType;
    }

    public void setCommandType(byte commandType) {
        this.commandType = commandType;
    }

    @Override
    public String toString() {
        return "JT809Msg_9504_DownCtrlMsgTakeTravelReq{" +
                "commandType=" + commandType +
                "} " + super.toString();
    }
}
