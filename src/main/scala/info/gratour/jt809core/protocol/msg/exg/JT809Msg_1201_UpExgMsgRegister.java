package info.gratour.jt809core.protocol.msg.exg;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

/**
 * revision: JT809-2011. The JT809-2019 is different to this.
 */
@JT809DataType(JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REGISTER_1201)
public class JT809Msg_1201_UpExgMsgRegister extends JT809UpExgMsg {

    public static final int DATA_TYPE = JT809MsgConsts.ExgMsgs.UP_EXG_MSG_REGISTER_1201;

    public JT809Msg_1201_UpExgMsgRegister() {
        setDataType(DATA_TYPE);
    }

    private String platformId;
    private String producerId;
    private String terminalModelType;
    private String terminalId;
    private String terminalSimCode;

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getProducerId() {
        return producerId;
    }

    public void setProducerId(String producerId) {
        this.producerId = producerId;
    }

    public String getTerminalModelType() {
        return terminalModelType;
    }

    public void setTerminalModelType(String terminalModelType) {
        this.terminalModelType = terminalModelType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getTerminalSimCode() {
        return terminalSimCode;
    }

    public void setTerminalSimCode(String terminalSimCode) {
        this.terminalSimCode = terminalSimCode;
    }

    @Override
    public String toString() {
        return "JT809Msg_1201_UpExgMsgRegister{" +
                "platformId='" + platformId + '\'' +
                ", producerId='" + producerId + '\'' +
                ", terminalModelType='" + terminalModelType + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", terminalSimCode='" + terminalSimCode + '\'' +
                "} " + super.toString();
    }
}
