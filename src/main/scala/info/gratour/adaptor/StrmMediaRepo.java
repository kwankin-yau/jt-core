/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.strm_media.AcquireLiveStrmReq;
import info.gratour.adaptor.types.strm_media.AcquireLiveStrmResult;
import info.gratour.adaptor.types.strm_media.AcquireVodStrmReq;
import info.gratour.adaptor.types.strm_media.AcquireVodStrmResult;
import info.gratour.adaptor.types.strm_media.LiveStrmCtrlReq;
import info.gratour.adaptor.types.strm_media.StrmMediaKeepAliveResult;
import info.gratour.adaptor.types.strm_media.VodStrmCtrlReq;
import info.gratour.gnss.core.strmmediaapi.StrmMediaApi;

import java.util.List;

public interface StrmMediaRepo {

    void updateTokens(List<StrmMediaApi.TimedToken> tokens);
    List<StrmMediaKeepAliveResult> keepAlive(List<String> reqIds);
    AcquireLiveStrmResult liveAcquire(AcquireLiveStrmReq req);

    /**
     *
     * @param req
     * @return error code
     * @see info.gratour.common.error.Errors
     */
    int liveCtrl(LiveStrmCtrlReq req);

    AcquireVodStrmResult vodAcquire(AcquireVodStrmReq req);

    /**
     *
     * @param req
     * @return error code
     * @see info.gratour.common.error.Errors
     */
    int vodCtrl(VodStrmCtrlReq req);

}
