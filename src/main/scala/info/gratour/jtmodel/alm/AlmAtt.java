/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel.alm;

import info.gratour.common.types.EpochMillis;

public class AlmAtt {

    private long id;
    private EpochMillis tm1;

    /**
     * 只用于创建AlmAtt记录时
     */
    private String simNo;
    private String name;
    private short typ;
    private EpochMillis fileTm;
    private int sz;

    /**
     * 在bucket内的路径，包括前面的 `/`，但不包括后面的 `/`
     */
    private String path;
    private String url;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EpochMillis getTm1() {
        return tm1;
    }

    public void setTm1(EpochMillis tm1) {
        this.tm1 = tm1;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public EpochMillis getFileTm() {
        return fileTm;
    }

    public void setFileTm(EpochMillis fileTm) {
        this.fileTm = fileTm;
    }

    public int getSz() {
        return sz;
    }

    public void setSz(int sz) {
        this.sz = sz;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Get file name with path, including the path prefix `/`
     *
     * @return file name with path including prefix `/`
     */
    public String fileNameWithPath() {
        String s = path;
        if (s == null || s.isEmpty())
            s = "/";
        else if (!s.startsWith("/"))
            s = "/" + s;

        if (!s.endsWith("/"))
            s = s  + "/";

        return s + name;
    }

    @Override
    public String toString() {
        return "AlmAtt{" +
                "id=" + id +
                ", tm1=" + tm1 +
                ", simNo='" + simNo + '\'' +
                ", name='" + name + '\'' +
                ", typ=" + typ +
                ", fileTm=" + fileTm +
                ", sz=" + sz +
                ", path='" + path + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
