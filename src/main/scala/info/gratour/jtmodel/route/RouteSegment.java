/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.route;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class RouteSegment {

    public static final Type LIST_TYPE = new TypeToken<List<RouteSegment>>(){}.getType();

    private int segmentId;
    private short width;
    private byte attrs;
    private int tmUpThold;
    private int tmLoThold;
    private short spdUpThold;
    private short overSpdTmThold;
    private List<Integer> cornerIds;

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public short getWidth() {
        return width;
    }

    public void setWidth(short width) {
        this.width = width;
    }

    public byte getAttrs() {
        return attrs;
    }

    public void setAttrs(byte attrs) {
        this.attrs = attrs;
    }

    public int getTmUpThold() {
        return tmUpThold;
    }

    public void setTmUpThold(int tmUpThold) {
        this.tmUpThold = tmUpThold;
    }

    public int getTmLoThold() {
        return tmLoThold;
    }

    public void setTmLoThold(int tmLoThold) {
        this.tmLoThold = tmLoThold;
    }

    public short getSpdUpThold() {
        return spdUpThold;
    }

    public void setSpdUpThold(short spdUpThold) {
        this.spdUpThold = spdUpThold;
    }

    public short getOverSpdTmThold() {
        return overSpdTmThold;
    }

    public void setOverSpdTmThold(short overSpdTmThold) {
        this.overSpdTmThold = overSpdTmThold;
    }

    public List<Integer> getCornerIds() {
        return cornerIds;
    }

    public void setCornerIds(List<Integer> cornerIds) {
        this.cornerIds = cornerIds;
    }

    public RouteSegment addCornerId(int cornerId) {
        if (cornerIds == null)
            cornerIds = new ArrayList<>();

        cornerIds.add(cornerId);

        return this;
    }

    @Override
    public String toString() {
        return "RouteSegment{" +
                "segmentId=" + segmentId +
                ", width=" + width +
                ", attrs=" + attrs +
                ", tmUpThold=" + tmUpThold +
                ", tmLoThold=" + tmLoThold +
                ", spdUpThold=" + spdUpThold +
                ", overSpdTmThold=" + overSpdTmThold +
                ", cornerIds=" + cornerIds +
                '}';
    }
}

