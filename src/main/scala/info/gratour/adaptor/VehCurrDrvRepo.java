/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.VehCurrDrv;

public interface VehCurrDrvRepo {
    VehCurrDrv load(long vehId);
    void put(VehCurrDrv currDrv);
}
