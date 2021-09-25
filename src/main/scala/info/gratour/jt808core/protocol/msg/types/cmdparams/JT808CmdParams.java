/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jtcommon.JTConsts;

public interface JT808CmdParams {

    default String toJson() {
        return JTConsts.GSON().toJson(this);
    }

    default String toJsonPretty() {
        return JTConsts.GSON_PRETTY().toJson(this);
    }

}
