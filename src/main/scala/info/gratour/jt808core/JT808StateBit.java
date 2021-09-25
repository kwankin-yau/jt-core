package info.gratour.jt808core;

import info.gratour.common.CommonMessages;
import info.gratour.common.utils.BitUtils;

import java.util.Locale;
import java.util.ResourceBundle;

class JT808StateNames {
    public static final String MESSAGE_KEY_ACC_ON = "state.acc_on.0";
    public static final String MESSAGE_KEY_LOCATED = "state.located.1";
    public static final String MESSAGE_KEY_SOUTH = "state.south.2";
    public static final String MESSAGE_KEY_WEST = "state.west.3";
    public static final String MESSAGE_KEY_OUT_OF_SERVICE = "state.out_of_serv.4";
    public static final String MESSAGE_KEY_ENCRYPT = "state.encrypt.5";
    public static final String MESSAGE_KEY_FULL = "state.full.8";
    public static final String MESSAGE_KEY_LOADING = "state.loading.9";
    public static final String MESSAGE_KEY_OIL_CUT = "state.oil_cut.10";
    public static final String MESSAGE_KEY_CIRCUIT_CUT = "state.circuit_cut.11";
    public static final String MESSAGE_KEY_DOOR_LOCKED = "state.door_locked.12";
    public static final String MESSAGE_KEY_FRONT_DOOR_OPEN = "state.front_door_open.13";
    public static final String MESSAGE_KEY_MID_DOOR = "state.mid_door_open.14";
    public static final String MESSAGE_KEY_END_DOOR = "state.end_door_open.15";
    public static final String MESSAGE_KEY_DRIVER_DOOR = "state.driver_door_open.16";
    public static final String MESSAGE_KEY_DOOR5 = "state.door5_open.17";
    public static final String MESSAGE_KEY_GPS = "state.gps.18";
    public static final String MESSAGE_KEY_BEIDOU = "state.beidou.19";
    public static final String MESSAGE_KEY_GLONASS = "state.glonass.20";
    public static final String MESSAGE_KEY_GALILEO = "state.galileo.21";

    private static final String[] MESSAGE_KEYS = new String[]{
            MESSAGE_KEY_ACC_ON,
            MESSAGE_KEY_LOCATED,
            MESSAGE_KEY_SOUTH,
            MESSAGE_KEY_WEST,
            MESSAGE_KEY_OUT_OF_SERVICE,
            MESSAGE_KEY_ENCRYPT,
            null, // 6
            null, // 7
            MESSAGE_KEY_FULL,
            MESSAGE_KEY_LOADING,
            MESSAGE_KEY_OIL_CUT,
            MESSAGE_KEY_CIRCUIT_CUT,
            MESSAGE_KEY_DOOR_LOCKED,
            MESSAGE_KEY_FRONT_DOOR_OPEN,
            MESSAGE_KEY_MID_DOOR,
            MESSAGE_KEY_END_DOOR,
            MESSAGE_KEY_DRIVER_DOOR,
            MESSAGE_KEY_DOOR5,
            MESSAGE_KEY_GPS,
            MESSAGE_KEY_BEIDOU,
            MESSAGE_KEY_GLONASS,
            MESSAGE_KEY_GALILEO
    };

    private static String stateMessageKey(int bitIndex) {
        if (bitIndex >= 0 && bitIndex < MESSAGE_KEYS.length)
            return MESSAGE_KEYS[bitIndex];
        else
            return null;
    }

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("info.gratour.jt808core.protocol.state-names", Locale.getDefault());

    private static String unknownBit(int bitIndex) {
        return CommonMessages.UNKNOWN() + "(bit:" + bitIndex + ")";
    }

    private static String[] unknownBits() {
        String[] r = new String[32];
        for (int i = 0; i < r.length; i++) {
            r[i] = unknownBit(i);
        }

        return r;
    }

    private static final String[] UNKNOWN_BITS = unknownBits();

    static String getStateName(int bitIndex) {
        String key = stateMessageKey(bitIndex);
        if (key != null)
            return BUNDLE.getString(key);
        else if (bitIndex >= 0 && bitIndex < UNKNOWN_BITS.length)
            return UNKNOWN_BITS[bitIndex];
        else
            return unknownBit(bitIndex);
    }

}

public enum JT808StateBit {

    ACC_ON(0),
    LOCATED(1),
    SOUTH(2),
    WEST(3),
    OUT_OF_SERVICE(4),
    ENCRYPT(5),

    FULL(8),
    LOADING(9),
    OIL_CUT(10),
    CIRCUIT_CUT(11),
    DOOR_LOCKED(12),
    FRONT_DOOR_OPEN(13),
    MID_DOOR_OPEN(14),
    END_DOOR_OPEN(15),
    DRIVER_DOOR_OPEN(16),
    DOOR5_OPEN(17),
    GPS(18),
    BEIDOU(19),
    GLONASS(20),
    GALILEO(21);


    private int index;
    private String stateName;


    JT808StateBit(int bitIndex) {
        this.index = bitIndex;
        this.stateName = JT808StateNames.getStateName(bitIndex);
    }

    public int bitIndex() {
        return index;
    }

    public String getStateName() {
        return stateName;
    }

    public static String vehStateText(int vehStateBits) {
        StringBuilder str = new StringBuilder();
        boolean first = true;
        for (JT808StateBit bit : values()) {
            if (BitUtils.test(vehStateBits, bit.index)) {
                if (first)
                    first = false;
                else
                    str.append(',');
                str.append(bit.getStateName());
            }
        }
        return str.toString();
    }
}
