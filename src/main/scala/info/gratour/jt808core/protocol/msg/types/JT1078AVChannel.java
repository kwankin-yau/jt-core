/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types;

import java.util.Locale;
import java.util.ResourceBundle;

public class JT1078AVChannel {

    public static final byte MEDIA_TYPE__AV = 0;
    public static final byte MEDIA_TYPE__AUDIO_ONLY = 1;

    private byte channelId;
    private String channelName;
    private byte mediaType;
    private boolean custom;

    public JT1078AVChannel() {
    }

    public JT1078AVChannel(byte channelId, String channelName, byte mediaType, boolean custom) {
        this.channelId = channelId;
        this.channelName = channelName;
        this.mediaType = mediaType;
        this.custom = custom;
    }

    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public byte getMediaType() {
        return mediaType;
    }

    public void setMediaType(byte mediaType) {
        this.mediaType = mediaType;
    }

    public boolean isCustom() {
        return custom;
    }

    public void setCustom(boolean custom) {
        this.custom = custom;
    }

    public String channelText() {
        return channelName + " (" + channelId + ")";
    }

    @Override
    public String toString() {
        return "JT1078AVChannel{" +
                "channelId=" + channelId +
                ", channelName='" + channelName + '\'' +
                ", mediaType=" + mediaType +
                ", custom=" + custom +
                '}';
    }

    public static final ResourceBundle CHANNEL_NAMES_BUNDLE = ResourceBundle.getBundle("info.gratour.jt808core.protocol.channel-names", Locale.getDefault());

    private static JT1078AVChannel ch(int channelId, boolean av) {
        String name = CHANNEL_NAMES_BUNDLE.getString("ch" + channelId);
        byte mediaType = av ? MEDIA_TYPE__AV : MEDIA_TYPE__AUDIO_ONLY;
        return new JT1078AVChannel((byte)channelId, name, mediaType, false);
    }

    public static JT1078AVChannel[] standardChannels() {
        return new JT1078AVChannel[] {
                ch(1, true),
                ch(2, true),
                ch(3, true),
                ch(4, true),
                ch(5, true),
                ch(6, true),
                ch(7, true),
                ch(8, true),
                ch(9, true),
                ch(10, true),
                ch(11, true),
                ch(12, true),
                ch(13, true),
                ch(33, false),
                ch(36, false),
                ch(37, false)
        };
    }
}
