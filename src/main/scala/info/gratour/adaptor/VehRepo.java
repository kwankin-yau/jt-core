/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.PlateNoAndColor;
import info.gratour.adaptor.types.VehCurrDrv;
import info.gratour.jtmodel.VehBrief;

import java.util.List;

public interface VehRepo {

    VehCurrDrv getVehCurrDrv(long vehId);
    VehCurrDrv getVehCurrDrv(String plateNo, int plateColor);

    VehBrief cachedGetVehBrief(long vehId);

    /**
     *
     * @param vehId null if not use vehId condition
     * @param plateNo null if not use plateNo condition
     * @param plateColor null if not use plateColor condition
     * @return
     */
    VehBrief[] qryVehBrief(Long vehId, String plateNo, Integer plateColor);
    VehBrief qryVehBriefBySimNo(String simNo);
    VehBrief[] fetchVehBriefNeedsUploadToGov(int fetchCount);



    void markVehBriefRegToGov(List<PlateNoAndColor> vehs);
}
