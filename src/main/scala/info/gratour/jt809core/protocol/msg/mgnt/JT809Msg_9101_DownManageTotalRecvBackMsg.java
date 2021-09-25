/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.protocol.msg.mgnt;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT809MsgConsts.ManageMsgs.DOWN_MANAGE_TOTAL_RECV_BACK_MSG_9101)
public class JT809Msg_9101_DownManageTotalRecvBackMsg extends JT809DownManageMsg {

    public static final int MSG_ID = JT809MsgConsts.ManageMsgs.DOWN_MANAGE_TOTAL_RECV_BACK_MSG_9101;

    public JT809Msg_9101_DownManageTotalRecvBackMsg() {
        setMsgId(MSG_ID);
    }

    private long dynamicInfoTotal;
    private long startTime;
    private long endTime;

    public long getDynamicInfoTotal() {
        return dynamicInfoTotal;
    }

    public void setDynamicInfoTotal(long dynamicInfoTotal) {
        this.dynamicInfoTotal = dynamicInfoTotal;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "JT809Msg_9101_DownManageTotalRecvBackMsg{" +
                "dynamicInfoTotal=" + dynamicInfoTotal +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "} " + super.toString();
    }
}
