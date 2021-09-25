/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jtmodel;

public class SysParam implements Comparable<SysParam> {

    public static final String SCOPE_GNSS_LINK = "gnssLink";

    public static final String TERM_AUTH_DISABLED = "termAuthDisabled";
    public static final String ALM_ATT_SERVER_HOST = "almAttServerHost";
    public static final String ALM_ATT_TCP_PORT = "almAttTcpPort";
//    public static final String STRM_MEDIA_RELAY_HOST = "strmMediaRelayHost";
//    public static final String STRM_MEDIA_RELAY_PORT = "strmMediaRelayTcpPort";
    public static final String DNS_SERVER = "dnsServer";
    public static final String AUTO_REQ_ALM_ATT_UPLOAD = "autoReqAlmAttUpload";
//    public static final String RTMP_SERVER_HOST = "rtmpServerHost";
//    public static final String RTMP_SERVICE_PORT = "rtmpServicePort";
//    public static final String RTMP_APP_NAME = "rtmpAppName";
//    public static final String FLV_SERVER_HOST = "flvServerHost";
//    public static final String FLV_SERVICE_PORT = "flvServicePort";
//    public static final String FLV_APP_NAME = "flvAppName";

    public static final String SCOPE_COMMON = "common";
    public static final String MAP_TYPE = "mapTyp";
    public static final String BAIDU_HTTP_KEY = "baiduHttpKey";
    public static final String BAIDU_SERV_VALIDATE_METH = "baiduServValidateMeth";
    public static final String ONLINE_INTV = "onlineIntv";
    public static final String DB_STRUCT = "dbStruct";

    private String scope;
    private String name;
    private String value;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static String qualifyParamName(String scope, String paramName) {
        return scope + ":" + paramName;
    }


    @Override
    public String toString() {
        return "SysParam{" +
                "scope='" + scope + '\'' +
                ", name='" + name + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


    @Override
    public int compareTo(SysParam o) {
        int r = scope.compareTo(o.scope);
        if (r != 0)
            return r;

        r = name.compareTo(o.name);
        if (r != 0)
            return r;

        if (value == null) {
            if (o.value == null)
                return 0;
            else
                return -1;
        } else if (o.value == null)
            return 1;
        else
            return value.compareTo(o.value);
    }
}
