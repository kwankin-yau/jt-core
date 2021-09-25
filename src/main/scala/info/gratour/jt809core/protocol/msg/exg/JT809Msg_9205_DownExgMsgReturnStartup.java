package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_RETURN_STARTUP_9205)
public class JT809Msg_9205_DownExgMsgReturnStartup extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_RETURN_STARTUP_9205;

    public JT809Msg_9205_DownExgMsgReturnStartup() {
        setDataType(DATA_TYPE);
    }

    private byte reasonCode;

    public byte getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(byte reasonCode) {
        this.reasonCode = reasonCode;
    }

    @Override
    public String toString() {
        return "JT809Msg_9205_DownExgMsgReturnStartup{" +
                "reasonCode=" + reasonCode +
                "} " + super.toString();
    }
}
