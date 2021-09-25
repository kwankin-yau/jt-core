/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.UpdateAVResReq;
import info.gratour.jtmodel.AVRes;

import java.util.List;

public interface AVResRepo {

//    AVRes createAVRes(CreateAVResReq req);

    /**
     *
     * @param plateNo
     * @param plateColor
     * @param channelId 0 as not specified
     * @param startTime must not be 0
     * @param endTime 0 as not specified
     * @return
     */
    List<AVRes> qryAVRes(String plateNo, short plateColor, byte channelId, long startTime, long endTime);
    boolean updateAVRes(UpdateAVResReq req);
}
