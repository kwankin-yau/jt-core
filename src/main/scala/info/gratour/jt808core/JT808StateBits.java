/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core;

import info.gratour.common.utils.BitUtils;

public class JT808StateBits {

    private int stateBits;

    public int getStateBits() {
        return stateBits;
    }

    public void setStateBits(int stateBits) {
        this.stateBits = stateBits;
    }

    public boolean test(JT808StateBit bit) {
        return BitUtils.test(stateBits, bit.bitIndex());
    }

    public boolean test(int bitIndex) {
        return BitUtils.test(stateBits, bitIndex);
    }

    public JT808StateBits set(JT808StateBit bit) {
        stateBits = BitUtils.set(stateBits, bit.bitIndex());
        return this;
    }

    public JT808StateBits set(int bitIndex) {
        stateBits = BitUtils.set(stateBits, bitIndex);
        return this;
    }

    public JT808StateBits clear(JT808StateBit bit) {
        stateBits = BitUtils.clear(stateBits, bit.bitIndex());
        return this;
    }

    public JT808StateBits clear(int bitIndex) {
        stateBits = BitUtils.clear(stateBits, bitIndex);
        return this;
    }

    public String getStateText() {
        return JT808StateBit.vehStateText(stateBits);
    }

    public static final JT808StateBits ACC_ON_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.ACC_ON).set(JT808StateBit.LOCATED);
    public static final JT808StateBits ACC_OFF_LOCATED = new JT808StateBits().set(JT808StateBit.BEIDOU).set(JT808StateBit.LOCATED);

    @Override
    public String toString() {
        return "JT808StateBits{" +
                "stateBits=" + stateBits +
                '}';
    }
}
