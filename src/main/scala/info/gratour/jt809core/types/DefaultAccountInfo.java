/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt809core.types;

public class DefaultAccountInfo implements AccountInfo {

    private int userId;
    private String password;

    public DefaultAccountInfo() {
    }

    public DefaultAccountInfo(int userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    @Override
    public int userId() {
        return userId;
    }

    @Override
    public String password() {
        return password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public DefaultAccountInfo clone() {
        DefaultAccountInfo r = new DefaultAccountInfo();
        r.userId = this.userId;
        r.password = this.password;
        return r;
    }

    @Override
    public String toString() {
        return "DefaultAccountInfo{" +
                "userId=" + userId +
                ", password='" + password + '\'' +
                "}";
    }
}
