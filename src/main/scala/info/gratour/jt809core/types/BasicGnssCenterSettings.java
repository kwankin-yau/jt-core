/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.types;

public class BasicGnssCenterSettings implements GnssCenterSettings {

    private String gnssAreaCode;
    private int gnssCenterId;
    private DefaultAccountInfo accountInfo;
    private boolean encrypt;
    private CryptParams cryptParams;

    public BasicGnssCenterSettings() {
    }

    public BasicGnssCenterSettings(int gnssCenterId, DefaultAccountInfo accountInfo, boolean encrypt, CryptParams cryptParams) {
        this.gnssCenterId = gnssCenterId;
        this.accountInfo = accountInfo;
        this.encrypt = encrypt;
        this.cryptParams = cryptParams;
    }

    public String getGnssAreaCode() {
        return gnssAreaCode;
    }

    public void setGnssAreaCode(String gnssAreaCode) {
        this.gnssAreaCode = gnssAreaCode;
    }

    public int getGnssCenterId() {
        return gnssCenterId;
    }

    public void setGnssCenterId(int gnssCenterId) {
        this.gnssCenterId = gnssCenterId;
    }

    public DefaultAccountInfo getAccountInfo() {
        return accountInfo;
    }

    public void setAccountInfo(DefaultAccountInfo accountInfo) {
        this.accountInfo = accountInfo;
    }

    public boolean isEncrypt() {
        return encrypt;
    }

    public void setEncrypt(boolean encrypt) {
        this.encrypt = encrypt;
    }

    public CryptParams getCryptParams() {
        return cryptParams;
    }

    public void setCryptParams(CryptParams cryptParams) {
        this.cryptParams = cryptParams;
    }

    @Override
    public String gnssAreaCode() {
        return gnssAreaCode;
    }

    @Override
    public int gnssCenterId() {
        return gnssCenterId;
    }

    @Override
    public String platformId() {
        return Integer.toString(gnssCenterId);
    }

    @Override
    public AccountInfo accountInfo() {
        return accountInfo;
    }

    @Override
    public boolean encrypt() {
        return encrypt;
    }

    @Override
    public CryptSettings cryptSettings() {
        return cryptParams.getSettings();
    }

    @Override
    public boolean isValidDownLinkIp(String downLinkIp) {
        return true;
    }

    @Override
    public boolean isValidDownLinkPort(int downLinkPort) {
        return true;
    }

    @Override
    public BasicGnssCenterSettings clone() {
        BasicGnssCenterSettings r = new BasicGnssCenterSettings();
        r.gnssAreaCode = gnssAreaCode;
        r.gnssCenterId = gnssCenterId;
        r.accountInfo = (accountInfo != null) ? accountInfo.clone() : null;
        r.encrypt = encrypt;
        r.cryptParams = (cryptParams != null) ? cryptParams.clone() : null;

        return r;
    }

    @Override
    public String toString() {
        return "BasicGnssCenterSettings{" +
                "gnssAreaCode='" + gnssAreaCode + '\'' +
                ", gnssCenterId=" + gnssCenterId +
                ", accountInfo=" + accountInfo +
                ", encrypt=" + encrypt +
                ", cryptParams=" + cryptParams +
                '}';
    }
}
