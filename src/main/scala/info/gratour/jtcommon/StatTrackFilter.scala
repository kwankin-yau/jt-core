/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.jtcommon

import info.gratour.jtmodel.trk.Trk

trait StatTrackFilter {

  def accept(trk: Trk): Boolean
}

object DefaultStatTrackFilter extends StatTrackFilter {
  override def accept(trk: Trk): Boolean = {
    trk.getLng != 0 && trk.getLat != 0
  }
}
