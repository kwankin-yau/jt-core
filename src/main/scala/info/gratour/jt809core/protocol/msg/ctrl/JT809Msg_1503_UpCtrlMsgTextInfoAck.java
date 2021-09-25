package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TEXT_INFO_ACK_1503)
public class JT809Msg_1503_UpCtrlMsgTextInfoAck extends JT809UpCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TEXT_INFO_ACK_1503;

    public static final byte RESULT__SUCCESS = 0;
    public static final byte RESULT__FAILED = 2;

    public JT809Msg_1503_UpCtrlMsgTextInfoAck() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject ackParamsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("reqMsgId", reqMsgId);
        o.addProperty("result", result);
        return o;
    }

    private int reqMsgId;
    private byte result;

    public int getReqMsgId() {
        return reqMsgId;
    }

    public void setReqMsgId(int reqMsgId) {
        this.reqMsgId = reqMsgId;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809Msg_1503_UpCtrlMsgTextInfoAck{" +
                "reqMsgId=" + reqMsgId +
                ", result=" + result +
                "} " + super.toString();
    }
}
