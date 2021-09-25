/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.CloseAlmReq;
import info.gratour.adaptor.types.CreateAlmReq;
import info.gratour.common.types.DateTimeQryCondition;
import info.gratour.jtmodel.alm.Alm;
import info.gratour.jtmodel.alm.AlmAtt;
import info.gratour.jtmodel.alm.AlmCntStat;
import info.gratour.jtmodel.alm.AlmParam;
import info.gratour.jtmodel.alm.CurrAlm;

import java.util.List;

public interface AlmRepo {

    /**
     * 查询指定业户适用的特定类型的报警参数
     *
     * @param corpId 业户ID
     * @param typ    报警类型
     * @return
     */
    AlmParam getAlmParam(long corpId, String typ);

    /**
     * 查询终端当前特定类型的报警
     *
     * @param simNo
     * @param typ   报警类型编码, null for all typ
     * @return
     */
    CurrAlm[] getCurrAlms(String simNo, String typ);

    /**
     * 创建报警
     *
     * @param req 创建报警请求
     */
    void createAlm(CreateAlmReq req);

    /**
     * 关闭报警
     *
     * @param req 关闭报警请求
     */
    void closeAlm(CloseAlmReq req);

    Alm qryAlmByTm1Typ(long tm1, short typ);

    void createAlmAtt(AlmAtt almAtt);

    List<AlmAtt> qryAlmAtts(long almId, DateTimeQryCondition tm1);

    List<AlmCntStat> qryAlmCntStat(String plateNo, int plateColor, DateTimeQryCondition tm1, String[] almTypes);

}

