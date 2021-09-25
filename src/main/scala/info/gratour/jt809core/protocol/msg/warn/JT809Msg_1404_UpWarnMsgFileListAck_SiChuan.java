package info.gratour.jt809core.protocol.msg.warn;

import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;
import info.gratour.jtcommon.JTUtils;
import org.apache.commons.codec.binary.Hex;

import java.util.ArrayList;
import java.util.List;

@JT809DataType(JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_FILELIST_ACK_1404)
public class JT809Msg_1404_UpWarnMsgFileListAck_SiChuan extends JT809UpWarnMsg {

    public static final int DATA_TYPE = JT809MsgConsts.WarnMsgs.UP_WARN_MSG_SICHUAN_FILELIST_ACK_1404;

    public JT809Msg_1404_UpWarnMsgFileListAck_SiChuan() {
        setDataType(DATA_TYPE);
    }

    private byte[] infoId;
    private String serverAddr;
    private int port;
    private String userName;
    private String password;
    private List<UpWarnMsgFileInfo_SiChuan> fileList;

    public byte[] getInfoId() {
        return infoId;
    }

    public void setInfoId(byte[] infoId) {
        this.infoId = infoId;
    }

    public void setInfoIdString(String infoId) {
        byte[] bytes = infoId.getBytes();
        if (bytes.length == 32)
            this.infoId = bytes;
        else if (bytes.length > 32) {
            this.infoId = new byte[32];
            System.arraycopy(bytes, 0, this.infoId, 0, 32);
        } else {
            this.infoId = new byte[32];
            System.arraycopy(bytes, 0, this.infoId, 0, bytes.length);
        }
    }

    public String getServerAddr() {
        return serverAddr;
    }

    public void setServerAddr(String serverAddr) {
        this.serverAddr = serverAddr;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UpWarnMsgFileInfo_SiChuan> getFileList() {
        return fileList;
    }

    public void setFileList(List<UpWarnMsgFileInfo_SiChuan> fileList) {
        this.fileList = fileList;
    }

    public void addFile(UpWarnMsgFileInfo_SiChuan file) {
        if (fileList == null)
            fileList = new ArrayList<>();

        fileList.add(file);
    }

    public int fileCount() {
        if (fileList == null)
            return 0;
        else
            return fileList.size();
    }

    public String infoIdHexString() {
        return Hex.encodeHexString(infoId);
    }

    @Override
    public String detailMessage() {
        StringBuilder str = new StringBuilder();
        if (fileList == null || fileList.isEmpty())
            str.append("[]");
        else {
            str.append('[');
            boolean first = true;
            for (UpWarnMsgFileInfo_SiChuan info : fileList) {
                if (first)
                    first = false;
                else {
                    str.append(',');
                }

                str.append(info);
            }
            str.append(']');
        }


        return "JT809Msg_1404_UpWarnMsgFileListAck_SiChuan{" +
                "infoId=" + JTUtils.cStr(infoId) +
                ", serverAddr='" + serverAddr + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fileList=" + str.toString() +
                "} " + super.toString();
    }

    @Override
    public String toString() {
        return "JT809Msg_1404_UpWarnMsgFileListAck_SiChuan{" +
                "infoId=" + JTUtils.cStr(infoId) +
                ", serverAddr='" + serverAddr + '\'' +
                ", port=" + port +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fileList=" + fileList +
                "} " + super.toString();
    }
}
