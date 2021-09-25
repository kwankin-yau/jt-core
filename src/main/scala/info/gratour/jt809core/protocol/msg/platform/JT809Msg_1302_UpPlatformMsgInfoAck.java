package info.gratour.jt809core.protocol.msg.platform;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.PlatformMsgs.UP_PLATFORM_MSG_INFO_ACK_1302)
public class JT809Msg_1302_UpPlatformMsgInfoAck extends JT809UpPlatformMsg {

    public static final int DATA_TYPE = JT809MsgConsts.PlatformMsgs.UP_PLATFORM_MSG_INFO_ACK_1302;

    public JT809Msg_1302_UpPlatformMsgInfoAck() {
        setDataType(DATA_TYPE);
    }

    private int infoId;

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    @Override
    public String toString() {
        return "JT809Msg_1302_UpPlatformMsgInfoAck{" +
                "infoId=" + infoId +
                "} " + super.toString();
    }
}
