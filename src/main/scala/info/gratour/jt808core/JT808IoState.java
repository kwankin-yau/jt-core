/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core;

import info.gratour.common.utils.BitUtils;

import java.util.Locale;
import java.util.ResourceBundle;

class JT808IoStateNames {
    public static final String MESSAGE_KEY_DEEP_SLEEP = "iost.deep_sleep.0";
    public static final String MESSAGE_KEY_SLEEP = "iost.sleep.1";

    private static final String[] MESSAGE_KEYS = new String[] {
            MESSAGE_KEY_DEEP_SLEEP,
            MESSAGE_KEY_SLEEP
    };

    private static String ioStateMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("info.gratour.jt808core.protocol.io-state-names", Locale.getDefault());

    public static String getStateName(int bitIndex) {
        String key = ioStateMessageKey(bitIndex);
        if (key != null)
            return BUNDLE.getString(key);
        else
            return null;
    }

}

public enum  JT808IoState {

    DEEP_SLEEP(0),
    SLEEP(1);


    private int index;
    private String stateName;

    JT808IoState(int bitIndex) {
        this.index = bitIndex;
        this.stateName = JT808IoStateNames.getStateName(bitIndex);
    }

    public int bitIndex() {
        return index;
    }

    public String stateName() {
        return stateName;
    }

    public static String vehIoStateText(int vehIoStateBits) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808IoState st: values()) {
            if (BitUtils.test(vehIoStateBits, st.index)) {
                if (first)
                    first = false;
                else
                    str.append(";");

                str.append(st.stateName);
            }
        }

        return str.toString();
    }

}
