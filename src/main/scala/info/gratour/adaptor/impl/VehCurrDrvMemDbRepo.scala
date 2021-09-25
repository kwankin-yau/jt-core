/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor.impl
import info.gratour.adaptor.VehCurrDrvRepo
import info.gratour.adaptor.types.VehCurrDrv
import info.gratour.common.service.MemDbService

class VehCurrDrvMemDbRepo(val memDb: MemDbService) extends VehCurrDrvRepo {

  private def key(vehId: Long): String = "vcd:" + vehId

  override def load(vehId: Long): VehCurrDrv =
    memDb.jsonGet[VehCurrDrv](key(vehId))

  override def put(currDrv: VehCurrDrv): Unit =
    memDb.jsonSet[VehCurrDrv](key(currDrv.getVehId), currDrv)

}
