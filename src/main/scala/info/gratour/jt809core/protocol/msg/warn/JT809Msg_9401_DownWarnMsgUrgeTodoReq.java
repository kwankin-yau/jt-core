package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;

@JT809DataType(JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_URGE_TODO_REQ_9401)
public class JT809Msg_9401_DownWarnMsgUrgeTodoReq extends JT809DownWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.DOWN_WARN_MSG_URGE_TODO_REQ_9401;

    public JT809Msg_9401_DownWarnMsgUrgeTodoReq() {
        setDataType(DATA_TYPE);
    }

    private byte warnSrc;
    private int warnType;
    private long warnTime;
    private int supervisionId;
    private long supervisionEndTime;
    private byte supervisionLevel;
    private String supervisor;
    private String supervisorTel;
    private String supervisorEmail;

    public byte getWarnSrc() {
        return warnSrc;
    }

    public void setWarnSrc(byte warnSrc) {
        this.warnSrc = warnSrc;
    }

    public int getWarnType() {
        return warnType;
    }

    public void setWarnType(int warnType) {
        this.warnType = warnType;
    }

    public long getWarnTime() {
        return warnTime;
    }

    public void setWarnTime(long warnTime) {
        this.warnTime = warnTime;
    }

    public int getSupervisionId() {
        return supervisionId;
    }

    public void setSupervisionId(int supervisionId) {
        this.supervisionId = supervisionId;
    }

    public long getSupervisionEndTime() {
        return supervisionEndTime;
    }

    public void setSupervisionEndTime(long supervisionEndTime) {
        this.supervisionEndTime = supervisionEndTime;
    }

    public byte getSupervisionLevel() {
        return supervisionLevel;
    }

    public void setSupervisionLevel(byte supervisionLevel) {
        this.supervisionLevel = supervisionLevel;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getSupervisorTel() {
        return supervisorTel;
    }

    public void setSupervisorTel(String supervisorTel) {
        this.supervisorTel = supervisorTel;
    }

    public String getSupervisorEmail() {
        return supervisorEmail;
    }

    public void setSupervisorEmail(String supervisorEmail) {
        this.supervisorEmail = supervisorEmail;
    }

    @Override
    public String toString() {
        return "JT809Msg_9401_DownWarnMsgUrgeTodoReq{" +
                "warnSrc=" + warnSrc +
                ", warnType=" + warnType +
                ", warnTime=" + warnTime +
                ", supervisionId=" + supervisionId +
                ", supervisionEndTime=" + supervisionEndTime +
                ", supervisionLevel=" + supervisionLevel +
                ", supervisor='" + supervisor + '\'' +
                ", supervisorTel='" + supervisorTel + '\'' +
                ", supervisorEmail='" + supervisorEmail + '\'' +
                "} " + super.toString();
    }
}
