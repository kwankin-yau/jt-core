package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtmodel.trk.Trk;

import java.util.ArrayList;
import java.util.List;

@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_HISTORY_LOCATION_1203)
public class JT809Msg_1203_UpExgMsgHistoryLocation extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_HISTORY_LOCATION_1203;

    public JT809Msg_1203_UpExgMsgHistoryLocation() {
        setDataType(DATA_TYPE);
    }

    private List<JT809GnssData> gnssDataList;

    public List<JT809GnssData> getGnssDataList() {
        return gnssDataList;
    }

    public void setGnssDataList(List<JT809GnssData> gnssDataList) {
        this.gnssDataList = gnssDataList;
    }

    public int count() {
        if (gnssDataList == null)
            return 0;
        else
            return gnssDataList.size();
    }

    public void add(JT809GnssData data) {
        if (gnssDataList == null)
            gnssDataList = new ArrayList<>();

        gnssDataList.add(data);
    }

    public void add(Trk trk) {
        JT809GnssData data = new JT809GnssData();
        data.assign(trk);

        add(data);
    }

    @Override
    public String toString() {
        return "JT809Msg_1203_UpExgMsgHistoryLocation{" +
                "gnssDataList=" + gnssDataList +
                "} " + super.toString();
    }
}
