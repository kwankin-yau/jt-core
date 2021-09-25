package info.gratour.jt809core.protocol;

import info.gratour.jtcommon.JTMsg;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;

public class JT809Msg implements JTMsg {

    private int msgId;
    private int msgSn;
    private int gnssCenterId;
    private long time;

    public JT809Msg() {
    }

    public JT809Msg(JT809FrameHeader header) {
        setHeader(header);
    }

    public void setHeader(JT809FrameHeader header) {
        this.msgId = header.getMsgId();
        this.msgSn = header.getMsgSn();
        this.gnssCenterId = header.getGnssCenterId();
        this.time = header.getTime();
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getMsgSn() {
        return msgSn;
    }

    public void setMsgSn(int msgSn) {
        this.msgSn = msgSn;
    }

    public int getGnssCenterId() {
        return gnssCenterId;
    }

    public void setGnssCenterId(int gnssCenterId) {
        this.gnssCenterId = gnssCenterId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String detailMessage() {
        return toString();
    }

    public String msgIdHexString() {
        return JTUtils.intToHex(msgId, 4, true);
    }

    @Override
    public String toString() {
        return "JT809Msg{" +
                "msgId=" + msgIdHexString() +
                ", msgSn=" + msgSn +
                ", gnssCenterId=" + gnssCenterId +
                ", time=" + time +
                '}';
    }

    public static JTMsgId getJTMsgIdAnnotation(Class<?> clzz) {
        JTMsgId r = clzz.getAnnotation(JTMsgId.class);
        if (r == null) {
            Class<?> p = clzz.getSuperclass();
            if (p != null)
                return getJTMsgIdAnnotation(p);
            else
                return null;
        } else
            return r;
    }

    @Override
    public int jtMsgId() {
        JTMsgId anno = getJTMsgIdAnnotation(getClass());
        if (anno != null)
            return anno.value();
        else
            return 0;
    }
}
