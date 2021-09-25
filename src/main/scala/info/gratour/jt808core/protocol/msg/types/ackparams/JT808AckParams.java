/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams;

import info.gratour.common.Consts;

public interface JT808AckParams {

    default String toJson() {
        return Consts.GSON.toJson(this);
    }

    default String toJsonPretty() {
        return Consts.GSON_PRETTY.toJson(this);
    }
}
