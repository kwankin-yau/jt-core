package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_OPERATION_INFO_1403)
public class JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_OPERATION_INFO_1403;

    public JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private byte[] infoId;
    private byte result;
    private byte method;
    private String operator;
    private String company;

    public byte[] getInfoId() {
        return infoId;
    }

    public void setInfoId(byte[] infoId) {
        this.infoId = infoId;
    }

    public byte getResult() {
        return result;
    }

    public void setResult(byte result) {
        this.result = result;
    }

    public byte getMethod() {
        return method;
    }

    public void setMethod(byte method) {
        this.method = method;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "JT809Msg_1403_UpWarnMsgOperationInfo_SiChuan{" +
                "infoId=" + Arrays.toString(infoId) +
                ", result=" + result +
                ", method=" + method +
                ", operator='" + operator + '\'' +
                ", company='" + company + '\'' +
                "} " + super.toString();
    }
}
