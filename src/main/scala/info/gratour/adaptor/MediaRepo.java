/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor;

import info.gratour.adaptor.types.CreateMMReq;
import info.gratour.jtmodel.MultiMedia;

public interface MediaRepo {

    MultiMedia createMedia(CreateMMReq req);
}
