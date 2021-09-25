package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_URGE_TODO_ACK_1401)
public class JT809Msg_1401_UpWarnMsgUrgeTodoAck extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_URGE_TODO_ACK_1401;

    public JT809Msg_1401_UpWarnMsgUrgeTodoAck() {
        setDataType(DATA_TYPE);
    }

    private int supervisionId;
    private byte result;

    public int getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(int supervisionId) {
        this.supervisionId = supervisionId;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "JT809Msg_1401_UpWarnMsgUrgeTodoAck{" +
                "supervisionId=" + supervisionId +
                ", result=" + result +
                "} " + super.toString();
    }
}
