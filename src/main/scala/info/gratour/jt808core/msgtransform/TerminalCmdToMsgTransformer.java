/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.msgtransform;

import info.gratour.jt808core.protocol.JT808Msg;
import info.gratour.jtmodel.TermCmd;

public interface TerminalCmdToMsgTransformer {

    JT808Msg toMsg(TermCmd cmd);
}
