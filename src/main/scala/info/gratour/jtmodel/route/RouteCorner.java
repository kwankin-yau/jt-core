/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.route;

import com.google.gson.reflect.TypeToken;
import info.gratour.jtmodel.Coordinate;

import java.lang.reflect.Type;
import java.util.List;

public class RouteCorner {

    public static final Type LIST_TYPE = new TypeToken<List<RouteCorner>>(){}.getType();

    private int cornerId;
    private Coordinate coord;

    public int getCornerId() {
        return cornerId;
    }

    public void setCornerId(int cornerId) {
        this.cornerId = cornerId;
    }

    public Coordinate getCoord() {
        return coord;
    }

    public void setCoord(Coordinate coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return "RouteCorner{" +
                "cornerId=" + cornerId +
                ", coord=" + coord +
                '}';
    }
}
