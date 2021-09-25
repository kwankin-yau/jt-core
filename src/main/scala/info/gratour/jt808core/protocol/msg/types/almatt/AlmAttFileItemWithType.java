/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.almatt;

public class AlmAttFileItemWithType extends AlmAttFileItem {

    private byte fileType;

    public byte getFileType() {
        return fileType;
    }

    public void setFileType(byte fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "AlmAttFileItemWithType{" +
                "fileType=" + fileType +
                "} " + super.toString();
    }
}
