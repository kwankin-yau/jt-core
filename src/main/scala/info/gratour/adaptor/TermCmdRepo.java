package info.gratour.adaptor;

import info.gratour.adaptor.types.CreateTermCmdReq;
import info.gratour.jtmodel.TermCmd;

import java.util.List;

public interface TermCmdRepo {

    /**
     * Query recent(issued in 24 hours) terminal command records.
     *
     * @param simNo required
     * @param status optional
     * @param msgId required
     * @param msgSn optional
     * @param subCmdType optional
     * @return matching terminal command records
     */
    List<TermCmd> queryRecentCmdBySimNo(String simNo, Integer status, String msgId,
                                        Integer msgSn, String subCmdType);

    TermCmd createCmd(CreateTermCmdReq req);
    TermCmd createCmd(TermCmd cmd);

    /**
     * The ackTime default to current milli-seconds.
     *
     * @param id
     * @param reqTm
     * @param ackMsgId
     * @param ackCode
     * @param ackParams
     * @param time
     */
    void markCmdSuccessById(long id, long reqTm, String ackMsgId, Integer ackCode, Object ackParams, Long time);

    default void markCmdSuccessById(long id, long reqTm, String ackMsgId, Integer ackCode, Object ackParams) {
        markCmdSuccessById(id, reqTm, ackMsgId, ackCode, ackParams, null);
    }

    void markCmdFailedById(long id, long reqTm, Integer ackCode, Long failedTime);

    default void markCmdFailedById(long id, long reqTm, Integer ackCode) {
        markCmdFailedById(id, reqTm, ackCode, null);
    }

    void markCmdCanceledById(long id, long reqTm, Long cancelTime);

    default void markCmdCanceledById(long id, long reqTm) {
        markCmdCanceledById(id, reqTm, null);
    }

    void markCmdUploaded(long id, long reqTm, Long uploadTime);

    default void markCmdUploaded(long id, long reqTm) {
        markCmdUploaded(id, reqTm, null);
    }

    void markCmdNotSupportedById(long id, long reqTm, Long failedTime);

    default void markCmdNotSupportedById(long id, long reqTm) {
        markCmdNotSupportedById(id, reqTm, null);
    }

    void markCmdSent(long id, long reqTm, int msgSeqNo, Long sentTime);

    default void markCmdSent(long id, long reqTm, int msgSeqNo) {
        markCmdSent(id, reqTm, msgSeqNo, null);
    }
}
