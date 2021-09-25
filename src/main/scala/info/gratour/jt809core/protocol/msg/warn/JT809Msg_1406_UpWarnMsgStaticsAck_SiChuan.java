package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

import java.util.ArrayList;
import java.util.List;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_STATICS_ACK_1406)
public class JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_STATICS_ACK_1406;

    public JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private List<UpWarnMsgStaticsItem_SiChuan> staticsItems;

    public List<UpWarnMsgStaticsItem_SiChuan> getStaticsItems() {
        return staticsItems;
    }

    public void setStaticsItems(List<UpWarnMsgStaticsItem_SiChuan> staticsItems) {
        this.staticsItems = staticsItems;
    }

    public void add(UpWarnMsgStaticsItem_SiChuan item) {
        if (staticsItems == null)
            staticsItems = new ArrayList<>();

        staticsItems.add(item);
    }

    @Override
    public String toString() {
        return "JT809Msg_1406_UpWarnMsgStaticsAck_SiChuan{" +
                "staticsItems=" + staticsItems +
                "} " + super.toString();
    }
}
