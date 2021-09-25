/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public class RegToGovGrpId {

    private long grpId;

    public RegToGovGrpId() {
    }

    public RegToGovGrpId(long grpId) {
        this.grpId = grpId;
    }

    public long getGrpId() {
        return grpId;
    }

    public void setGrpId(long grpId) {
        this.grpId = grpId;
    }

    @Override
    public String toString() {
        return "GrpId{" +
                "grpId=" + grpId +
                '}';
    }
}
