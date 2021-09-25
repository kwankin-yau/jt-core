package info.gratour.adaptor.almatt

import java.io.OutputStream

import info.gratour.jtmodel.alm.AlmAtt

trait AlmAttFileStorage {

  def createFile(almAtt: AlmAtt): AlmAttFileStream
  def getUrl(almAtt: AlmAtt): String
}

case class AlmAttFileStream(almAtt: AlmAtt, out: OutputStream)
