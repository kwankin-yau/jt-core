package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TEXT_INFO_REQ_9503)
public class JT809Msg_9503_DownCtrlMsgTextInfoReq extends JT809DownCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TEXT_INFO_REQ_9503;

    public JT809Msg_9503_DownCtrlMsgTextInfoReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject paramsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("msgSeqNo", msgSeqNo);
        o.addProperty("msgPriority", msgPriority);
        o.addProperty("msgContent", msgContent);
        return o;
    }

    private int msgSeqNo;
    private byte msgPriority;
    private String msgContent;

    public int getMsgSeqNo() {
        return msgSeqNo;
    }

    public void setMsgSeqNo(int msgSeqNo) {
        this.msgSeqNo = msgSeqNo;
    }

    public byte getMsgPriority() {
        return msgPriority;
    }

    public void setMsgPriority(byte msgPriority) {
        this.msgPriority = msgPriority;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    @Override
    public String toString() {
        return "JT809Msg_9503_DownCtrlMsgTextInfoReq{" +
                "msgSeqNo=" + msgSeqNo +
                ", msgPriority=" + msgPriority +
                ", msgContent='" + msgContent + '\'' +
                "} " + super.toString();
    }
}
