/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.govsubmit;

public class GovSubmitMsg {

    public static final int TYP__ALM_RPT = 1;
    public static final int TYP__ALM_PROC_RPT = 2;
    public static final int TYP__SAFETY_TERM_INST = 3;


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
        return "GovSubmitMsg{" +
                "typ=" + typ +
                ", msg=" + msg +
                '}';
    }
}
