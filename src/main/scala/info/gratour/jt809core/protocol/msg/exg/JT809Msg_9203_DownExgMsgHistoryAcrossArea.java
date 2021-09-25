package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

import java.util.List;

@JT809DataType(JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_HISTORY_ACROSSAREA_9203)
public class JT809Msg_9203_DownExgMsgHistoryAcrossArea extends JT809DownExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.DOWN_EXG_MSG_HISTORY_ACROSSAREA_9203;

    public JT809Msg_9203_DownExgMsgHistoryAcrossArea() {
        setDataType(DATA_TYPE);
    }

    private List<JT809GnssData> gnssDataList;

    public List<JT809GnssData> getGnssDataList() {
        return gnssDataList;
    }

    public void setGnssDataList(List<JT809GnssData> gnssDataList) {
        this.gnssDataList = gnssDataList;
    }

    @Override
    public String toString() {
        return "JT809Msg_9203_DownExgMsgHistoryAcrossArea{" +
                "gnssDataList=" + gnssDataList +
                "} " + super.toString();
    }
}
