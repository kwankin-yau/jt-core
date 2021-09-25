/*******************************************************************************
 *  Copyright (c) 2019, 2021 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.adaptor.types;

public interface IPlateNoAndColor {
    String getPlateNo();
    int getPlateColor();

    default String plateNoStr() {
        return getPlateNo() + "_" + getPlateColor();
    }
}
