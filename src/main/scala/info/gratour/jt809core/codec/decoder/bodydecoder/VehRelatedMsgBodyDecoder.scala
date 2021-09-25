package info.gratour.jt809core.codec.decoder.bodydecoder
import info.gratour.jt809core.protocol.msg.JT809VehRelatedMsg
import info.gratour.jt809core.protocol.{JT809FrameHeader, JT809Msg}
import info.gratour.jtcommon.{JTUtils, NettyUtils}
import io.netty.buffer.ByteBuf

trait VehRelatedMsgBodyDecoder extends JT809MsgBodyDecoder {

  def decodeSubBody(
                         msg: JT809VehRelatedMsg,
                         buf: ByteBuf): Unit

  def msgClasses: Seq[Class[_ <: JT809VehRelatedMsg]]

  def msgClassMapper: Map[Int, Class[_ <: JT809VehRelatedMsg]] = {
    val classes = msgClasses
    classes.map(c => {
      val dataType = c.getField("DATA_TYPE").getInt(null)
      dataType -> c
    }).toMap
  }


  override def decode(header: JT809FrameHeader, body: ByteBuf): JT809Msg = {
    val vehAndDataType = VehAndDataTypeDecoder.decode(body, tempBuf)
    val clzz = msgClassMapper.get(vehAndDataType.dataType).orNull
    if (clzz == null) {
      val r = new JT809VehRelatedMsg
      r.setHeader(header)
      r.setVehAndDataType(vehAndDataType)

      return r
    }


    val instance = clzz.newInstance()
    instance.setHeader(header)
    instance.setVehAndDataType(vehAndDataType)

    val dataLength = body.readInt() // bad data-length

    val subBody = body.slice(body.readerIndex(), body.readableBytes())
    subBody.readerIndex(0)
    logger.debug("subBody=" + NettyUtils.bufToHex(subBody))
    decodeSubBody(instance, subBody)
    instance
  }

//  def newMsg[C <: JT809VehRelatedMsg](header: JT809FrameHeader, vehAndDataType: VehAndDataType)(implicit classTag: ClassTag[C]): C = {
//    val instance = classTag.runtimeClass.newInstance().asInstanceOf[C]
//    instance.setHeader(header)
//    instance.setVehAndDataType(vehAndDataType)
//    instance
//  }

}
case class VehAndDataType(vehicleNo: String, vehicleColor: Byte, dataType: Int) {

  override def toString: String = {
    val dt = JTUtils.intToHex(dataType, 4)
    s"VehAndDataType($vehicleNo, $vehicleColor, $dt)"
  }

}
