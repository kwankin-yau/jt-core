package info.gratour.jt809core.protocol.msg.warn;

public class UpWarnMsgStaticsItem_SiChuan {

    private int warnType;
    private int statics;

    public int getWarnType() {
        return warnType;
    }

    public void setWarnType(int warnType) {
        this.warnType = warnType;
    }

    public int getStatics() {
        return statics;
    }

    public void setStatics(int statics) {
        this.statics = statics;
    }

    @Override
    public String toString() {
        return "UpWarnMsgStaticsItem_SiChuan{" +
                "warnType=" + warnType +
                ", statics=" + statics +
                '}';
    }
}
