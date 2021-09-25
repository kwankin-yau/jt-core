package info.gratour.jt809core.protocol.msg.base;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.BaseMsgs.UP_BASE_MSG_VEHICLE_ADDED_ACK_1601)
public class JT809Msg_1601_UpBaseMsgVehicleAddedAck extends JT809UpBaseMsg {

    public static final int DATA_TYPE = JT809MsgConsts.BaseMsgs.UP_BASE_MSG_VEHICLE_ADDED_ACK_1601;

    public JT809Msg_1601_UpBaseMsgVehicleAddedAck() {
        setDataType(DATA_TYPE);
    }

    private String carInfo;

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    @Override
    public String toString() {
        return "JT809Msg_1601_UpBaseMsgVehicleAddedAck{" +
                "carInfo='" + carInfo + '\'' +
                "} " + super.toString();
    }
}
