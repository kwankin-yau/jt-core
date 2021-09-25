package info.gratour.jt809core.protocol.msg.link;

import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.LinkMsgs.DOWN_CLOSELINK_INFORM_9008)
public class JT809Msg_9008_DownCloseLinkInform extends JT809Msg {

    public static final int MSG_ID = JT809MsgConsts.LinkMsgs.DOWN_CLOSELINK_INFORM_9008;

    public JT809Msg_9008_DownCloseLinkInform() {
        setMsgId(MSG_ID);
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
        return "JT809Msg_9008_DownCloseLinkInform{" +
                "reasonCode=" + reasonCode +
                "} " + super.toString();
    }
}
