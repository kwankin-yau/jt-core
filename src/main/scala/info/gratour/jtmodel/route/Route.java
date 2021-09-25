/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.route;

import info.gratour.common.Consts;
import info.gratour.common.error.ErrorWithCode;
import info.gratour.common.error.Errors;
import info.gratour.common.types.EpochMillis;
import info.gratour.common.utils.DateTimeUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Route {

    private long routeId;
    private String routeName;
    private long grpId;
    private String grpName;
    private short attrs;
    private String startTm;
    private String endTm;
    private List<RouteSegment> segments;
    private List<RouteCorner> corners;
    private String description;
    private EpochMillis createTm;
    private EpochMillis updateTm;

    public long getRouteId() {
        return routeId;
    }

    public void setRouteId(long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    public String getGrpName() {
        return grpName;
    }

    public void setGrpName(String grpName) {
        this.grpName = grpName;
    }

    public short getAttrs() {
        return attrs;
    }

    public void setAttrs(short attrs) {
        this.attrs = attrs;
    }

    public String getStartTm() {
        return startTm;
    }

    public void setStartTm(String startTm) {
        this.startTm = startTm;
    }

    public EpochMillis startTmToEpochMillis() {
        if (startTm != null) {
            String tm;
            if (startTm.equals("00-00-00 00:00:00"))
                tm = "0000-00-00 00:00:00";
            else
                tm = "20" + startTm;
            return EpochMillis.apply(LocalDateTime.parse(tm, DateTimeUtils.CONVENIENT_DATETIME_FORMATTER()).atOffset(Consts.ZONE_OFFSET_BEIJING));
        } else
            return null;
    }

    public void setStartTm(EpochMillis epochMillis) {
        if (epochMillis == null)
            startTm = null;
        else
            startTm = epochMillis.toLocalDateTimeBeijing().format(DateTimeUtils.CONVENIENT_DATETIME_FORMATTER()).substring(2);
    }

    public String getEndTm() {
        return endTm;
    }

    public void setEndTm(String endTm) {
        this.endTm = endTm;
    }

    public EpochMillis endTmToEpochMillis() {
        if (endTm != null) {
            String tm;
            if (endTm.equals("00-00-00 00:00:00"))
                tm = "0000-00-00 00:00:00";
            else
                tm = "20" + endTm;
            return EpochMillis.apply(LocalDateTime.parse(tm, DateTimeUtils.CONVENIENT_DATETIME_FORMATTER()).atOffset(Consts.ZONE_OFFSET_BEIJING));
        } else
            return null;
    }

    public void setEndTm(EpochMillis epochMillis) {
        if (epochMillis == null)
            endTm = null;
        else
            endTm = epochMillis.toLocalDateTimeBeijing().format(DateTimeUtils.CONVENIENT_DATETIME_FORMATTER()).substring(2);
    }

    public List<RouteSegment> getSegments() {
        return segments;
    }

    public void setSegments(List<RouteSegment> segments) {
        this.segments = segments;
    }

    public Route addSegment(RouteSegment segment) {
        if (segments == null)
            segments = new ArrayList<>();

        segments.add(segment);
        return this;
    }

    public List<RouteCorner> getCorners() {
        return corners;
    }

    public void setCorners(List<RouteCorner> corners) {
        this.corners = corners;
    }

    public Route addCorner(RouteCorner corner) {
        if (corners == null)
            corners = new ArrayList<>();

        corners.add(corner);

        return this;
    }

    public RouteCorner findCorner(int cornerId) {
        if (corners != null) {
            for (RouteCorner c : corners) {
                if (c.getCornerId() == cornerId)
                    return c;
            }
        }

        return null;
    }

    public RouteCorner getCorner(int cornerId) {
        RouteCorner r = findCorner(cornerId);
        if (r == null)
            throw new ErrorWithCode(Errors.RECORD_NOT_FOUND, String.format("Invalid corner `%d`.", cornerId));

        return r;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EpochMillis getCreateTm() {
        return createTm;
    }

    public void setCreateTm(EpochMillis createTm) {
        this.createTm = createTm;
    }

    public EpochMillis getUpdateTm() {
        return updateTm;
    }

    public void setUpdateTm(EpochMillis updateTm) {
        this.updateTm = updateTm;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId=" + routeId +
                ", routeName='" + routeName + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", attrs=" + attrs +
                ", startTm='" + startTm + '\'' +
                ", endTm='" + endTm + '\'' +
                ", segments=" + segments +
                ", corners=" + corners +
                ", description='" + description + '\'' +
                ", createTm=" + createTm +
                ", updateTm=" + updateTm +
                '}';
    }
}
