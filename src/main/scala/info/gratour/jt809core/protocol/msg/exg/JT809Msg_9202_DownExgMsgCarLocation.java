package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_CAR_LOCATION_9202)
public class JT809Msg_9202_DownExgMsgCarLocation extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_CAR_LOCATION_9202;

    public JT809Msg_9202_DownExgMsgCarLocation() {
        setDataType(DATA_TYPE);
    }

    private JT809GnssData gnssData;

    public JT809GnssData getGnssData() {
        return gnssData;
    }

    public void setGnssData(JT809GnssData gnssData) {
        this.gnssData = gnssData;
    }

    @Override
    public String toString() {
        return "JT809Msg_9202_DownExgMsgCarLocation{" +
                "gnssData=" + gnssData +
                "} " + super.toString();
    }
}
