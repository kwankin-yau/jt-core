/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808RouteCorner;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.SET_ROUTE_8606)
public class CP_8606_SetRoute implements JT808CmdParams {

    private int routeId;
    private short attrs;
    private String startTime;
    private String endTime;
    private JT808RouteCorner[] corners;

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public short getAttrs() {
        return attrs;
    }

    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public JT808RouteCorner[] getCorners() {
        return corners;
    }

    public void setCorners(JT808RouteCorner[] corners) {
        this.corners = corners;
    }

    @Override
    public String toString() {
        return "CP_8606_SetRoute{" +
                "routeId=" + routeId +
                ", attrs=" + attrs +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", corners=" + Arrays.toString(corners) +
                '}';
    }
}
