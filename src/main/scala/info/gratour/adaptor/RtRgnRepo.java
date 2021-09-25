/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.common.types.rest.Pagination;
import info.gratour.common.types.rest.Reply;
import info.gratour.jtmodel.rgn.PlatRgn;
import info.gratour.jtmodel.rgn.TermRgn;
import info.gratour.jtmodel.route.TermRouteNeedSync;

import java.util.List;

public interface RtRgnRepo {

    List<TermRouteNeedSync> qryTermRoutesNeedSync();
    boolean markTermRouteSync(String simNo, long routeId);

    List<TermRgn> qryTermRgnsNeedSync();
    boolean markTermRgnSync(String simNo, long rgnId);

    Reply<PlatRgn> qryPlatRgnEnabled(Pagination pagination, boolean withGrpsAndVehs);
    PlatRgn qryPlatRgnEnabled(String platRgnId);
}
