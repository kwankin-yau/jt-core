package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REAL_LOCATION_1202)
public class JT809Msg_1202_UpExgMsgRealLocation extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REAL_LOCATION_1202;

    public JT809Msg_1202_UpExgMsgRealLocation() {
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
        return "JT809Msg_1202_UpExgMsgRealLocation{" +
                "gnssData=" + gnssData +
                "} " + super.toString();
    }
}
