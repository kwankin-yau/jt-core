/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

import info.gratour.jt808core.protocol.msg.types.cmdparams.JT808CmdParams;
import info.gratour.jtcommon.JTUtils;

public class CreateTermCmdReq {

    private String msgId;
    private String subCmdTyp;
    private String simNo;
    private String plateNo;
    private Short plateColor;
    private short cmdSrc;
    private Long userId;
    private JT808CmdParams params;

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public void setJtMsgId(int msgId) {
        this.msgId = JTUtils.msgIdToHex(msgId);
    }

    public int jtMsgId() {
        return Integer.parseInt(msgId, 16);
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

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public Short getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(Short plateColor) {
        this.plateColor = plateColor;
    }

    public short getCmdSrc() {
        return cmdSrc;
    }

    public void setCmdSrc(short cmdSrc) {
        this.cmdSrc = cmdSrc;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


    @Override
    public String toString() {
        return "CreateTermCmdReq{" +
                "msgId='" + msgId + '\'' +
                ", subCmdTyp='" + subCmdTyp + '\'' +
                ", simNo='" + simNo + '\'' +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", cmdSrc=" + cmdSrc +
                ", userId=" + userId +
                ", params=" + params +
                '}';
    }
}
