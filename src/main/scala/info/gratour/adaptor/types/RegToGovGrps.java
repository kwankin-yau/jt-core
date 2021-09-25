/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

import java.util.ArrayList;
import java.util.List;

public class RegToGovGrps {

    private List<RegToGovGrpId> grps;

    public List<RegToGovGrpId> getGrps() {
        return grps;
    }

    public void setGrps(List<RegToGovGrpId> grps) {
        this.grps = grps;
    }

    public void add(RegToGovGrpId grpId) {
        if (this.grps == null)
            this.grps = new ArrayList<>();

        this.grps.add(grpId);
    }

    public void add(long grpId) {
        RegToGovGrpId gid = new RegToGovGrpId(grpId);
        add(gid);
    }

    public long[] toIds() {
        if (grps != null && grps.size() > 0) {
            long[] r = new long[grps.size()];
            for (int i = 0; i < grps.size(); i++) {
                r[i] = grps.get(i).getGrpId();
            }

            return r;
        } else
            return new long[0];
    }

    @Override
    public String toString() {
        return "RegToGovGrps{" +
                "grps=" + grps +
                '}';
    }
}
