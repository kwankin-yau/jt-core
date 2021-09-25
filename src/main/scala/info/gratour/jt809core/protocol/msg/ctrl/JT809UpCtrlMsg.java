package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.common.Consts;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_1500)
abstract public class JT809UpCtrlMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_1500;

    public JT809UpCtrlMsg() {
        setMsgId(MSG_ID);
    }

    public abstract JsonObject ackParamsJson();

    public String ackParamsJsonString() {
        JsonObject o = ackParamsJson();
        return Consts.GSON.toJson(o);
    }

    @Override
    public String toString() {
        return "JT809UpCtrlMsg{} " + super.toString();
    }
}
