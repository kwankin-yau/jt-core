package info.gratour.jtmodel;

import info.gratour.common.types.EpochMillis;
import info.gratour.jt808core.protocol.msg.types.ackparams.JT808AckParams;
import info.gratour.jt808core.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jtcommon.JTUtils;

import java.util.HashMap;
import java.util.Map;

public class TermCmd {

    public static final int CMD_STATUS__INIT = 0;
    public static final int CMD_STATUS__SENT = 1;
    public static final int CMD_STATUS__SUCCESS = 2;
    public static final int CMD_STATUS__UPLOADED = 3;
    public static final int CMD_STATUS__FAILED = -1;
    public static final int CMD_STATUS__BAD_CMD = -2;
    public static final int CMD_STATUS__NOT_SUPPORTED = -3;
    public static final int CMD_STATUS__CANCELED = -4;

    public static final short CMD_SRC__USER = 1;
    public static final short CMD_SRC__BACKEND = 2;
    public static final short CMD_SRC__GOV = 3;
    public static final short CMD_SRC__SURROGATE = 4;

    private long id;
    private String msgId;
    private String subCmdTyp;
    private String simNo;
    private long grpId;
    private long vehId;
    private String plateNo;
    private Integer plateColor;
    private EpochMillis reqTm;
    private EpochMillis sentTm;
    private EpochMillis ackTm;
    private EpochMillis endTm;
    private int cmdSrc;
    private int status;
    private Integer msgSn;
    private Integer ackCode;
    private Long userId;
    private String userName;
    private JT808CmdParams params;
    private JT808AckParams ackParams;
    transient private Map<String, Object> processorInfo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String idStr() {
        return Long.toString(id);
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public int msgIdToInt() {
        if (msgId != null)
            return Integer.parseInt(msgId, 16);
        else
            return 0;
    }

    public void setMsgId(int msgId) {
        this.msgId = JTUtils.intToHex(msgId, 4);
    }

    public String getSubCmdTyp() {
        return subCmdTyp;
    }

    public void setSubCmdTyp(String subCmdTyp) {
        this.subCmdTyp = subCmdTyp;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public long getVehId() {
        return vehId;
    }

    public void setVehId(long vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Integer getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Integer plateColor) {
        this.plateColor = plateColor;
    }

    public EpochMillis getReqTm() {
        return reqTm;
    }

    public void setReqTm(EpochMillis reqTm) {
        this.reqTm = reqTm;
    }

    public EpochMillis getSentTm() {
        return sentTm;
    }

    public void setSentTm(EpochMillis sentTm) {
        this.sentTm = sentTm;
    }

    public EpochMillis getAckTm() {
        return ackTm;
    }

    public void setAckTm(EpochMillis ackTm) {
        this.ackTm = ackTm;
    }

    public EpochMillis getEndTm() {
        return endTm;
    }

    public void setEndTm(EpochMillis endTm) {
        this.endTm = endTm;
    }

    public int getCmdSrc() {
        return cmdSrc;
    }

    public void setCmdSrc(int cmdSrc) {
        this.cmdSrc = cmdSrc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Integer getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(Integer msgSn) {
        this.msgSn = msgSn;
    }

    public Integer getAckCode() {
        return ackCode;
    }

    public void setAckCode(Integer ackCode) {
        this.ackCode = ackCode;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public JT808CmdParams getParams() {
        return params;
    }

    public void setParams(JT808CmdParams params) {
        this.params = params;
    }

    public String paramsToJson() {
        if (params != null)
            return params.toJson();
        else
            return null;
    }

    public String paramsToJsonPretty() {
        if (params != null)
            return params.toJsonPretty();
        else
            return null;
    }

    public JT808AckParams getAckParams() {
        return ackParams;
    }

    public void setAckParams(JT808AckParams ackParams) {
        this.ackParams = ackParams;
    }

    public String ackParamsToJson() {
        if (ackParams != null)
            return ackParams.toJson();
        else
            return null;
    }

    public String ackParamsToJsonPretty() {
        if (ackParams != null)
            return ackParams.toJsonPretty();
        else
            return null;
    }

    public synchronized Object getProcessInfo(String attrName) {
        if (processorInfo == null)
            return null;
        else
            return processorInfo.get(attrName);
    }

    public synchronized void setProcessorInfo(String attrName, Object attrValue) {
        if (processorInfo == null)
            processorInfo = new HashMap<>();

        processorInfo.put(attrName, attrValue);
    }

    @Override
    public String toString() {
        return "TermCmd{" +
                "id=" + id +
                ", msgId='" + msgId + '\'' +
                ", subCmdTyp='" + subCmdTyp + '\'' +
                ", simNo='" + simNo + '\'' +
                ", grpId=" + grpId +
                ", vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", reqTm=" + reqTm +
                ", sentTm=" + sentTm +
                ", ackTm=" + ackTm +
                ", endTm=" + endTm +
                ", cmdSrc=" + cmdSrc +
                ", status=" + status +
                ", msgSn=" + msgSn +
                ", ackCode=" + ackCode +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", params=" + params +
                ", ackParams=" + ackParams +
                '}';
    }
}
