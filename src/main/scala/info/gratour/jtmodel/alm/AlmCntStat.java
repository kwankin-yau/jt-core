/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import java.util.ArrayList;
import java.util.List;

public class AlmCntStat {

    public static class AlmCntStatEntry {
        private String typ;
        private int count;

        public String getTyp() {
            return typ;
        }

        public void setTyp(String typ) {
            this.typ = typ;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    private long vehId;
    private String plateNo;
    private int plateColor;
    private long grpId;
    private String grpName;

    private List<AlmCntStatEntry> statEntries;

    public long getVehId() {
        return vehId;
    }

    public void setVehId(long vehId) {
        this.vehId = vehId;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public int getPlateColor() {
        return plateColor;
    }

    public void setPlateColor(int plateColor) {
        this.plateColor = plateColor;
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

    public List<AlmCntStatEntry> getStatEntries() {
        return statEntries;
    }

    public void setStatEntries(List<AlmCntStatEntry> statEntries) {
        this.statEntries = statEntries;
    }

    public void add(AlmCntStatEntry entry) {
        if (statEntries == null)
            statEntries = new ArrayList<>();

        statEntries.add(entry);
    }

    @Override
    public String toString() {
        return "AlmCntStat{" +
                "vehId=" + vehId +
                ", plateNo='" + plateNo + '\'' +
                ", plateColor=" + plateColor +
                ", grpId=" + grpId +
                ", grpName='" + grpName + '\'' +
                ", statEntries=" + statEntries +
                '}';
    }
}
