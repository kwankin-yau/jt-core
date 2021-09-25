/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.types;

public class CryptSettings {

    private int m;
    private int ia;
    private int ic;

    public CryptSettings() {
    }

    public CryptSettings(int m, int ia, int ic) {
        this.m = m;
        this.ia = ia;
        this.ic = ic;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getIa() {
        return ia;
    }

    public void setIa(int ia) {
        this.ia = ia;
    }

    public int getIc() {
        return ic;
    }

    public void setIc(int ic) {
        this.ic = ic;
    }

    @Override
    public CryptSettings clone() {
        CryptSettings r = new CryptSettings();
        r.m = m;
        r.ia = ia;
        r.ic = ic;

        return r;
    }

    @Override
    public String toString() {
        return "CryptSettings{" +
                "m=" + m +
                ", ia=" + ia +
                ", ic=" + ic +
                '}';
    }
}
