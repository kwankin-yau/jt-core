package info.gratour.jt809core.protocol.msg.base;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.BaseMsgs.DOWN_BASE_MSG_VEHICLE_ADDED_9601)
public class JT809Msg_9601_DownBaseMsgVehicleAdded extends JT809DownBaseMsg {

    public static final int DATA_TYPE = JT809MsgConsts.BaseMsgs.DOWN_BASE_MSG_VEHICLE_ADDED_9601;

    public JT809Msg_9601_DownBaseMsgVehicleAdded() {
        setDataType(DATA_TYPE);
    }

    @Override
    public String toString() {
        return "JT809Msg_9601_DownBaseMsgVehicleAdded{} " + super.toString();
    }
}
