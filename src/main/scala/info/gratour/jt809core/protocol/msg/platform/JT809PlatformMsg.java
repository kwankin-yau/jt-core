package info.gratour.jt809core.protocol.msg.platform;

import info.gratour.jt809core.protocol.JT809Msg;

public class JT809PlatformMsg extends JT809Msg  {

    public static final int OBJECT_TYPE__CONNECTING_PLATFORM = 0x01;
    public static final int OBJECT_TYPE__SPECIFIED_CORP = 0x02;
    public static final int OBJECT_TYPE__ALL_CORP = 03;

    private int dataType;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    @Override
    public String toString() {
        return "JT809PlatformMsg{" +
                "dataType=" + dataType +
                "} " + super.toString();
    }
}
