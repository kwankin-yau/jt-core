/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types.strm_media;

public interface AcquireStrmReq {
    String getSimNo();
    byte getChannel();
    int getProto();
    byte getConnIdx();
    boolean isDisableAudio();
    ServerHint getStrmServerHint();
}
