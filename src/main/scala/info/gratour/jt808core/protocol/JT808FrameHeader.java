package info.gratour.jt808core.protocol;

import info.gratour.jtcommon.JTUtils;

public class JT808FrameHeader {

    private int msgId;
    private int attr;
    private String simNo;
    private int seqNo;
    private FrameSplitInfo splitInfo;

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public int getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(int seqNo) {
        this.seqNo = seqNo;
    }

    public boolean isSplit() {
        return splitInfo != null;
    }

    public FrameSplitInfo getSplitInfo() {
        return splitInfo;
    }

    public void setSplitInfo(FrameSplitInfo splitInfo) {
        this.splitInfo = splitInfo;
    }

    @Override
    public String toString() {
        return "JT808FrameHeader{" +
                "msgId=" + JTUtils.msgIdToHex(msgId) +
                ", attr=" + attr +
                ", simNo='" + simNo + '\'' +
                ", seqNo=" + seqNo +
                ", splitInfo=" + splitInfo +
                '}';
    }
}
