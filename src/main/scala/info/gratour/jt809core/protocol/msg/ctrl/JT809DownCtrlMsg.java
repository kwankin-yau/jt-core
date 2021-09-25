package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.common.Consts;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_9500)
abstract public class JT809DownCtrlMsg extends JT809VehRelatedMsg {

    public static final int MSG_ID = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_9500;

    public JT809DownCtrlMsg() {
        setMsgId(MSG_ID);
    }

    public abstract JsonObject paramsJson();

    public String paramsJsonString() {
        JsonObject o = paramsJson();
        return Consts.GSON.toJson(o);
    }

    @Override
    public String toString() {
        return "JT809DownCtrlMsg{} " + super.toString();
    }
}
