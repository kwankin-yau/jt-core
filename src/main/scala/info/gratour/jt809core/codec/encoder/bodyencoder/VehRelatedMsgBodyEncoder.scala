package info.gratour.jt809core.codec.encoder.bodyencoder
import info.gratour.jt809core.protocol.JT809Msg
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import io.netty.buffer.ByteBuf

trait VehRelatedMsgBodyEncoder extends MsgBodyEncoder {

  def encodeSubBody(msg: JT809VehRelatedMsg, out: ByteBuf): Unit

  override def encodeBody(m: JT809Msg, out: ByteBuf): Unit = {
    val msg = m.asInstanceOf[JT809VehRelatedMsg]

    out.writeFixedLenStr(msg.getVehicleNo, 21)
    out.writeByte(msg.getVehicleColor)
    out.writeShort(msg.getDataType)
    val dataLengthOffset = out.writerIndex()
    out.writeInt(0) // data-length stub
    encodeSubBody(msg, out)
    val dataLength = out.writerIndex() - dataLengthOffset - 4
    if (dataLength > 0) {
      out.setInt(dataLengthOffset, dataLength)
    }
  }
}
