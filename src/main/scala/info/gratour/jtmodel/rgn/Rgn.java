/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

import info.gratour.common.types.EpochMillis;
import info.gratour.jtmodel.Coordinate;

import java.util.List;

public class Rgn implements Shape {

    public static final String TYP__TERM = "term";
    public static final String TYP__PLAT = "plat";
    public static final String TYP__TERM_PLAT = "term_plat";

    public static final String SHP__CIRCLE = "circle";
    public static final String SHP__RECT = "rect";
    public static final String SHP__POLYGON = "polygon";

    private int rgnId;
    private String rgnName;
    private String typ;
    private long grpId;
    private String grpName;
    private String shp;
    private Coordinate center;
    private Integer radius;
    private List<Coordinate> vectors;
    private String description;
    private EpochMillis createTm;
    private EpochMillis updateTm;

    public int getRgnId() {
        return rgnId;
    }

    public void setRgnId(int rgnId) {
        this.rgnId = rgnId;
    }

    public String getRgnName() {
        return rgnName;
    }

    public void setRgnName(String rgnName) {
        this.rgnName = rgnName;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
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

    public String getShp() {
        return shp;
    }

    public void setShp(String shp) {
        this.shp = shp;
    }

    public Coordinate getCenter() {
        return center;
    }

    public void setCenter(Coordinate center) {
        this.center = center;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public List<Coordinate> getVectors() {
        return vectors;
    }

    public void setVectors(List<Coordinate> vectors) {
        this.vectors = vectors;
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
        return "Rgn{" +
                "rgnId=" + rgnId +
                ", rgnName='" + rgnName + '\'' +
                ", typ='" + typ + '\'' +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", shp='" + shp + '\'' +
                ", center=" + center +
                ", radius=" + radius +
                ", vectors=" + vectors +
                ", description='" + description + '\'' +
                ", createTm=" + createTm +
                ", updateTm=" + updateTm +
                '}';
    }
}
