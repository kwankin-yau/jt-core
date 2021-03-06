/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.vtdr;

import java.util.ArrayList;
import java.util.List;

public class VTDR_Status {
    private byte stateWord;
    private List<String> bitDesc;

    public byte getStateWord() {
        return stateWord;
    }

    public void setStateWord(byte stateWord) {
        this.stateWord = stateWord;
    }

    public List<String> getBitDesc() {
        return bitDesc;
    }

    public void setBitDesc(List<String> bitDesc) {
        this.bitDesc = bitDesc;
    }

    public void addBitDesc(String bitDesc) {
        if (this.bitDesc == null)
            this.bitDesc = new ArrayList<>();
        this.bitDesc.add(bitDesc);
    }

    @Override
    public String toString() {
        return "VTDR_Status{" +
                "stateWord=" + stateWord +
                ", bitDesc=" + bitDesc +
                '}';
    }
}
