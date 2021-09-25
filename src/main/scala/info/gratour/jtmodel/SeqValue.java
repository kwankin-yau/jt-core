/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

public class SeqValue {

    private String seqName;
    private long nextVal;

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public long getNextVal() {
        return nextVal;
    }

    public void setNextVal(long nextVal) {
        this.nextVal = nextVal;
    }

    @Override
    public String toString() {
        return "SeqValue{" +
                "seqName='" + seqName + '\'' +
                ", nextVal=" + nextVal +
                '}';
    }
}
