/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.jtmodel.TermBrief;
import info.gratour.jtmodel.term.UpdateTermAVAttrsReq;

public interface TermRepo {

    enum TermRegResult {
        OK,
        VEH_NOT_FOUND,
        TERM_NOT_FOUND,
        VEH_REGISTERED,
        TERM_REGISTERED;

        public boolean isOk() {
            return this == OK;
        }
    }
    TermRegResult termRegister(String simNo, String plateNo, int plateColor, String authCode);

    enum TermUnregResult {
        OK,
        TERM_NOT_FOUND;

        public boolean isOk() {
            return this == OK;
        }
    }
    TermUnregResult termUnregister(String simNo);

    /**
     *
     * @param simNo
     * @return null if not found
     */
    String qryTermAuthCode(String simNo);

    /**
     *
     * @param simNo
     * @return
     */
    TermBrief qryTermBrief(String simNo);

    boolean updateTermAVAttrs(UpdateTermAVAttrsReq req);
}
