/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govissue;

public class GovIssueAckMsg {

    public static final int TYP__GOV_INSPECT_ACK = 1;
    public static final int TYP__ALM_SUPERVISE_ACK = 2;

    private int typ;
    private Object msg;

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "GovIssueAckMsg{" +
                "typ=" + typ +
                ", msg=" + msg +
                '}';
    }
}
