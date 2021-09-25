/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JTSiChuanMsgConsts;
import info.gratour.jt808core.protocol.msg.types.almatt.AlmAttFileItemWithType;
import info.gratour.jt808core.protocol.msg.types.almatt.AlmAttReTransFileBlock;
import info.gratour.jtcommon.JTMsgId;

import java.util.List;

@JTMsgId(JTSiChuanMsgConsts.ALM_ATT_FILE_ITEM_COMPLETED_9212)
public class CP_9212_AlmAttFileItemCompleted implements JT808CmdParams {

    private AlmAttFileItemWithType fileItem;
    private List<AlmAttReTransFileBlock> reTransFileBlocks;

    public AlmAttFileItemWithType getFileItem() {
        return fileItem;
    }

    public void setFileItem(AlmAttFileItemWithType fileItem) {
        this.fileItem = fileItem;
    }

    public List<AlmAttReTransFileBlock> getReTransFileBlocks() {
        return reTransFileBlocks;
    }

    public void setReTransFileBlocks(List<AlmAttReTransFileBlock> reTransFileBlocks) {
        this.reTransFileBlocks = reTransFileBlocks;
    }

    @Override
    public String toString() {
        return "CP_9212_AlmAttFileItemCompleted{" +
                "fileItem=" + fileItem +
                ", reTransFileBlocks=" + reTransFileBlocks +
                '}';
    }
}
