/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types;

public class JT808InfoMenuItem {

    private byte infoType;
    private String infoName;

    public byte getInfoType() {
        return infoType;
    }

    public void setInfoType(byte infoType) {
        this.infoType = infoType;
    }

    public String getInfoName() {
        return infoName;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }

    @Override
    public String toString() {
        return "JT808InfoMenuItem{" +
                "infoType=" + infoType +
                ", infoName='" + infoName + '\'' +
                '}';
    }
}
