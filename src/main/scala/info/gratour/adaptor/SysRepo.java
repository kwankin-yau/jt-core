/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.common.utils.StringUtils;

public interface SysRepo {

    long nextSeqValue(String seqName);

    void invalidCache();


    /**
     * Get system parameter value.
     *
     * @param scope parameter scope
     * @param name parameter name
     * @return the corresponding parameter value. null if value is null or not defined. The implementation may be return a cached value
     */
    String getSysParam(String scope, String name);
    default String getSysParam(String scope, String name, String defaultValue) {
        String r = getSysParam(scope, name);
        if (r == null)
            return defaultValue;
        else
            return r;
    }

    default int getSysParamAsInt(String scope, String name, int defaultValue) {
        String v = getSysParam(scope, name);
        if (v != null) {
            Integer r = StringUtils.tryParseInt(v);
            if (r != null)
                return r;
            else
                return defaultValue;
        } else
            return defaultValue;
    }

    default boolean getSysParamAsBool(String scope, String name, boolean defaultValue) {
        String v = getSysParam(scope, name);
        if (v != null) {
            Boolean r = StringUtils.tryParseBool(v);
            if (r != null)
                return r;
            else
                return defaultValue;
        } else
            return defaultValue;
    }
}
