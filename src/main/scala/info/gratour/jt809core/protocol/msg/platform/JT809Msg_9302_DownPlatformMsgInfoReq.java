package info.gratour.jt809core.protocol.msg.platform;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.PlatformMsgs.DOWN_PLATFORM_MSG_INFO_REQ_9302)
public class JT809Msg_9302_DownPlatformMsgInfoReq extends JT809DownPlatformMsg {

    public static final int DATA_TYPE = JT809MsgConsts.PlatformMsgs.DOWN_PLATFORM_MSG_INFO_REQ_9302;

    public JT809Msg_9302_DownPlatformMsgInfoReq() {
        setDataType(DATA_TYPE);
    }

    private byte objectType;
    private String objectId;
    private int infoId;
    private String infoContent;

    public byte getObjectType() {
        return objectType;
    }

    public void setObjectType(byte objectType) {
        this.objectType = objectType;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    @Override
    public String toString() {
        return "JT809Msg_9302_DownPlatformMsgInfoReq{" +
                "objectType=" + objectType +
                ", objectId='" + objectId + '\'' +
                ", infoId=" + infoId +
                ", infoContent='" + infoContent + '\'' +
                "} " + super.toString();
    }
}
