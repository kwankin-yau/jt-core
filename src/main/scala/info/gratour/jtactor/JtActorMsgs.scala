/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtactor

import info.gratour.jtmodel.alm.AlmRpt
import info.gratour.jtmodel.trk.Trk

object JtActorMsgs {

  trait JtActorMessage

//  case object StartActor extends JtActorMessage
//  case object StopActor extends JtActorMessage

  case class TermOnline(simNo: String) extends JtActorMessage
  case class TermOffline(simNo: String) extends JtActorMessage
  case class TrkReceived(trk: Trk) extends JtActorMessage
  case class AlmRptReceived(alm: AlmRpt) extends JtActorMessage
  case class ExceptionCaught(cause: Throwable) extends JtActorMessage
}

