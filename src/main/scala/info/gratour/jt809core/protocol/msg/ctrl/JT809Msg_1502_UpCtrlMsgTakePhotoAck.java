package info.gratour.jt809core.protocol.msg.ctrl;

import com.google.gson.JsonObject;
import info.gratour.jt809core.protocol.JT809MsgConsts;
import info.gratour.jt809core.protocol.msg.types.JT809GnssData;
import info.gratour.jtcommon.JT809DataType;
import info.gratour.jtcommon.JTMsgId;
import org.apache.commons.codec.binary.Hex;

import java.util.Arrays;

@JT809DataType(JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TAKE_PHOTO_ACK_1502)
public class JT809Msg_1502_UpCtrlMsgTakePhotoAck extends JT809UpCtrlMsg {

    public static final int DATA_TYPE = JT809MsgConsts.CtrlMsgs.UP_CTRL_MSG_TAKE_PHOTO_ACK_1502;

    public static final byte PHOTO_RSP_FLAG__NOT_SUPPORTED = 0;
    public static final byte PHOTO_RSP_FLAG__COMPLETED = 1;
    public static final byte PHOTO_RSP_FLAG__DELAYED = 2;
    public static final byte PHOTO_RSP_FLAG__NOT_ONLINE = 3;
    public static final byte PHOTO_RSP_FLAG__LENS_UNAVAILABLE = 4;
    public static final byte PHOTO_RSP_FLAG__FAILED_OTHER_REASON = 5;
    public static final byte PHOTO_RSP_FLAG__INVALID_PLATE_NO = 6;

    public JT809Msg_1502_UpCtrlMsgTakePhotoAck() {
        setDataType(DATA_TYPE);
    }

    @Override
    public JsonObject ackParamsJson() {
        JsonObject o = new JsonObject();
        o.addProperty("photoRspFlag", photoRspFlag);
        o.add("gnssData", gnssData != null ? gnssData.toJsonObject() : null);
        o.addProperty("lensId", lensId);
        o.addProperty("photoBinary", photoBinary != null ? Hex.encodeHexString(photoBinary) : null);
        o.addProperty("sizeType", sizeType);
        o.addProperty("format", format);
        return o;
    }

    private byte photoRspFlag;
    private JT809GnssData gnssData;
    private byte lensId;
    private byte[] photoBinary;
    private byte sizeType;
    private byte format;

    public byte getPhotoRspFlag() {
        return photoRspFlag;
    }

    public void setPhotoRspFlag(byte photoRspFlag) {
        this.photoRspFlag = photoRspFlag;
    }

    public JT809GnssData getGnssData() {
        return gnssData;
    }

    public void setGnssData(JT809GnssData gnssData) {
        this.gnssData = gnssData;
    }

    public byte getLensId() {
        return lensId;
    }

    public void setLensId(byte lensId) {
        this.lensId = lensId;
    }

    public byte[] getPhotoBinary() {
        return photoBinary;
    }

    public void setPhotoBinary(byte[] photoBinary) {
        this.photoBinary = photoBinary;
    }

    public byte getSizeType() {
        return sizeType;
    }

    public void setSizeType(byte sizeType) {
        this.sizeType = sizeType;
    }

    public byte getFormat() {
        return format;
    }

    public void setFormat(byte format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return "JT809Msg_1502_UpCtrlMsgTakePhotoAck{" +
                "photoRspFlag=" + photoRspFlag +
                ", gnssData=" + gnssData +
                ", lenId=" + lensId +
                ", photoBinary=" + Arrays.toString(photoBinary) +
                ", sizeType=" + sizeType +
                ", format=" + format +
                "} " + super.toString();
    }
}
