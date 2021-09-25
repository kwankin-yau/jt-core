/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types;

import info.gratour.jtmodel.Coordinate;

public class JT808RouteCorner {

    private int cornerId;
    private int segmentId;
    private Coordinate coord;
    private byte width;
    private byte attrs;
    private int tmUpThold;
    private int tmLoThold;
    private short spdUpThold;
    private short overSpdTmThold;

    public int getCornerId() {
        return cornerId;
    }

    public void setCornerId(int cornerId) {
        this.cornerId = cornerId;
    }

    public int getSegmentId() {
        return segmentId;
    }

    public void setSegmentId(int segmentId) {
        this.segmentId = segmentId;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    public byte getWidth() {
        return width;
    }

    public void setWidth(byte width) {
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

    @Override
    public String toString() {
        return "JT808RouteCorner{" +
                "cornerId=" + cornerId +
                ", segmentId=" + segmentId +
                ", coord=" + coord +
                ", width=" + width +
                ", attrs=" + attrs +
                ", tmUpThold=" + tmUpThold +
                ", tmLoThold=" + tmLoThold +
                ", spdUpThold=" + spdUpThold +
                ", overSpdTmThold=" + overSpdTmThold +
                '}';
    }
}
