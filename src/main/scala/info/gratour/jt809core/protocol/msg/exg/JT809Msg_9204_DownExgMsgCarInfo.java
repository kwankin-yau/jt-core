package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_CAR_INFO_9204)
public class JT809Msg_9204_DownExgMsgCarInfo extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_CAR_INFO_9204;

    public JT809Msg_9204_DownExgMsgCarInfo() {
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
        return "JT809Msg_9204_DownExgMsgCarInfo{" +
                "carInfo='" + carInfo + '\'' +
                "} " + super.toString();
    }
}
