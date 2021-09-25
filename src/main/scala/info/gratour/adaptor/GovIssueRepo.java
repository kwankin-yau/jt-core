/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.MarkInspectAckSentReq;
import info.gratour.jtmodel.govissue.AlmSupervise;
import info.gratour.jtmodel.govissue.GovInspect;

public interface GovIssueRepo {
    void createGovInspect(GovInspect req);

    /**
     *
     * @param req
     * @return the AlmSupervise with tm property, note: the grpName does not filled
     */
    AlmSupervise createAlmSupervise(AlmSupervise req);

    void markGovInspectAckSent(MarkInspectAckSentReq req);
}
