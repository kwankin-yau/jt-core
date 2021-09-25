/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.rgn;

import info.gratour.jtmodel.Coordinate;

import java.util.List;

public interface Shape {

    String getShp();

    void setShp(String shp);

    Coordinate getCenter();

    void setCenter(Coordinate center);

    Integer getRadius();

    void setRadius(Integer radius);

    default int radiusDef() {
        Integer r = getRadius();
        if (r != null)
            return r;
        else
            return 0;
    }

    List<Coordinate> getVectors();

    void setVectors(List<Coordinate> vectors);

    default Coordinate vectorsMinXMinY() {
        double x = Double.MAX_VALUE;
        double y = x;

        for (Coordinate coord : getVectors()) {
            double d = coord.getLng();
            if (d < x)
                x = d;

            d = coord.getLat();
            if (d < y)
                y = d;
        }

        return new Coordinate(x, y);
    }

    default Coordinate vectorsMaxXMaxY() {
        double x = Double.MIN_VALUE;
        double y = x;

        for (Coordinate coord : getVectors()) {
            double d = coord.getLng();
            if (d > x)
                x = d;

            d = coord.getLat();
            if (d > y)
                y = d;
        }

        return new Coordinate(x, y);
    }
}
