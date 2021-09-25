/** *****************************************************************************
 * Copyright (c) 2019, 2020 lucendar.com.
 * All rights reserved.
 *
 * Contributors:
 * KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 * ******************************************************************************/
package info.gratour.adaptor

trait SeqValueProvider {



  /**
   * Get next sequence value
   *
   * @return 0 if not available
   */
  def tryGet: Long

}

object SeqValueProvider {
  val SEQ_TRK_ID = "s_trk_id"
  val SEQ_ALM_ID = "s_alm_id"
  val SEQ_GOV_ISSUE_ID = "s_gov_issue_id"
//  val SEQ_TERM_CMD_ID = "s_term_cmd_id"
}
