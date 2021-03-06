/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.codec.decoder.fragment;

import info.gratour.jt808core.protocol.JT808Frame;

public interface CollectedFragment {

    int getMsgId();

    /**
     * All fragments stubs, null element for not received, otherwise received.
     *
     * @return
     */
    JT808Frame[] getFrames();

    int getTotalCount();

    int getRecvCount();

    boolean isAllFragmentReceived();
}
