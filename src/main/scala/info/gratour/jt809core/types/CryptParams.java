/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.types;

import info.gratour.jt809core.JT809Utils;
import io.netty.buffer.ByteBuf;

public class CryptParams {

    private int key;
    private CryptSettings settings;

    public CryptParams() {
    }

    public CryptParams(int key, CryptSettings settings) {
        this.key = key;
        this.settings = settings;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public CryptSettings getSettings() {
        return settings;
    }

    public void setSettings(CryptSettings settings) {
        this.settings = settings;
    }

    public void encrypt(ByteBuf input, int size, ByteBuf output){
        JT809Utils.encrypt(key, settings.getM(), settings.getIa(), settings.getIc(), input, size, output);
    }

    public void decrypt(ByteBuf input, int size, ByteBuf output) {
        JT809Utils.decrypt(key, settings.getM(), settings.getIa(), settings.getIc(), input, size, output);
    }

    @Override
    public CryptParams clone() {
        CryptParams r = new CryptParams();
        r.key = key;
        r.settings = (settings != null) ? settings.clone() : null;
        return r;
    }

    @Override
    public String toString() {
        return "CryptParams{" +
                "key=" + key +
                ", settings=" + settings +
                '}';
    }
}
