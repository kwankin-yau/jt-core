package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.common.utils.CommonUtils;
import info.gratour.common.utils.StringUtils;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

@JT809DataType(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_FILELIST_REQ_9404)
public class JT809Msg_9404_DownWarnMsgFileListReq_Sichuan extends JT809DownWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_SICHUAN_FILELIST_REQ_9404;

    public JT809Msg_9404_DownWarnMsgFileListReq_Sichuan() {
        setDataType(DATA_TYPE);
    }

    private byte[] infoId;

    public byte[] getInfoId() {
        return infoId;
    }

    public void setInfoId(byte[] infoId) {
        this.infoId = infoId;
    }

    public void setInfoIdString(String infoId) {
        byte[] bytes = infoId.getBytes();
        if (bytes.length == 32)
            this.infoId = bytes;
        else if (bytes.length > 32) {
            this.infoId = new byte[32];
            System.arraycopy(bytes, 0, this.infoId, 0, 32);
        } else {
            this.infoId = new byte[32];
            System.arraycopy(bytes, 0, this.infoId, 0, bytes.length);
        }
    }

    public String infoIdString() {
        return StringUtils.cStr(infoId);
    }

    @Override
    public String toString() {
        return "JT809Msg_9404_DownWarnMsgFileListReq_Sichuan{" +
                "infoId=" + JTUtils.cStr(infoId) +
                "} " + super.toString();
    }
}
