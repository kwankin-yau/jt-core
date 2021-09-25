package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TAKE_PHOTO_REQ_9502)
public class JT809Msg_9502_DownCtrlMsgTakePhotoReq extends JT809DownCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.DOWN_CTRL_MSG_TAKE_PHOTO_REQ_9502;

    public JT809Msg_9502_DownCtrlMsgTakePhotoReq() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject paramsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("lensId", lensId);
        o.addProperty("sizeType", sizeType);
        return o;
    }

    private byte lensId;
    private byte sizeType;

    public byte getLensId() {
        return lensId;
    }

    public void setLensId(byte lensId) {
        this.lensId = lensId;
    }

    public byte getSizeType() {
        return sizeType;
    }

    public void setSizeType(byte sizeType) {
        this.sizeType = sizeType;
    }

    @Override
    public String toString() {
        return "JT809Msg_9502_DownCtrlMsgTakePhotoReq{" +
                "lensId=" + lensId +
                ", sizeType=" + sizeType +
                "} " + super.toString();
    }
}
