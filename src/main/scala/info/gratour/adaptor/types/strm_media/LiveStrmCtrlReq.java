/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

public class LiveStrmCtrlReq {

    public static final byte CTRL__CLOSE = 0;
    public static final byte CTRL__SWITCH_CODE_STREAM = 1;
    public static final byte CTRL__PAUSE = 2;
    public static final byte CTRL__RESUME = 3;
    public static final byte CTRL__CLOSE_TALK = 4;

    public static final byte CLOSE_ACTION__CLOSE_FULLY = 0;
    public static final byte CLOSE_ACTION__MUTE = 1;
    public static final byte CLOSE_ACTION__CLOSE_VIDEO = 2;

    public static final byte CODE_STREAM__PRIMARY = 0;
    public static final byte CODE_STREAM__SUB = 1;

    private String reqId;
    private byte ctrl;
    private Byte closeAction;
    private Byte codeStream;
    private ServerHint strmServerHint;
    private String closeReason;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public byte getCtrl() {
        return ctrl;
    }

    public void setCtrl(byte ctrl) {
        this.ctrl = ctrl;
    }

    public Byte getCloseAction() {
        return closeAction;
    }

    public void setCloseAction(Byte closeAction) {
        this.closeAction = closeAction;
    }

    public byte closeActionDef() {
        if (closeAction == null)
            return 0;
        else
            return closeAction;
    }

    public Byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(Byte codeStream) {
        this.codeStream = codeStream;
    }

    public byte codeStreamDef() {
        if (codeStream == null)
            return 0;
        else
            return codeStream;
    }

    public ServerHint getStrmServerHint() {
        return strmServerHint;
    }

    public void setStrmServerHint(ServerHint strmServerHint) {
        this.strmServerHint = strmServerHint;
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason;
    }

    @Override
    public String toString() {
        return "LiveStrmCtrlReq{" +
                "reqId='" + reqId + '\'' +
                ", ctrl=" + ctrl +
                ", closeAction=" + closeAction +
                ", codeStream=" + codeStream +
                ", strmServerHint=" + strmServerHint +
                ", closeReason='" + closeReason + '\'' +
                '}';
    }

}
