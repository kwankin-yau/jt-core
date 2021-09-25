/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.ackparams;

import info.gratour.jt808core.protocol.JT808MsgConsts;
import info.gratour.jt808core.protocol.msg.types.JT808MediaInfo;
import info.gratour.jtcommon.JTMsgId;

import java.util.Arrays;

@JTMsgId(JT808MsgConsts.STORED_MEDIA_SEARCH_ACK_0802)
public class JT808AckParams_0802_StoredMediaSearchAck implements JT808AckParams {

    private JT808MediaInfo[] mediaInfos;

    public JT808MediaInfo[] getMediaInfos() {
        return mediaInfos;
    }

    public void setMediaInfos(JT808MediaInfo[] mediaInfos) {
        this.mediaInfos = mediaInfos;
    }

    @Override
    public String toString() {
        return "JT808AckParams_0802_StoredMediaSearchAck{" +
                "mediaInfos=" + Arrays.toString(mediaInfos) +
                '}';
    }
}
