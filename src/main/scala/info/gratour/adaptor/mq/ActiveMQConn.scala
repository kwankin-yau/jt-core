package info.gratour.adaptor.mq

import java.util.Properties

import info.gratour.common.types.ConnParams
import javax.jms.ConnectionFactory
import org.apache.activemq.ActiveMQConnectionFactory
import org.apache.activemq.pool.PooledConnectionFactory

//trait ActiveMQConn extends MQConn {
//  override def createConnFactory(): ConnectionFactory = new ActiveMQConnectionFactory(connParams.getUrl)
//}

//trait PooledActiveMQConn extends ActiveMQConn {
//  override def createConnFactory(): ConnectionFactory = {
//    val connFactory = super.createConnFactory().asInstanceOf[ActiveMQConnectionFactory]
//    new PooledConnectionFactory(connFactory)
//  }
//}
//
//class ActiveMQConnConfigFromProperties extends ActiveMQConn {
//
//  protected def getProperties: Properties = {
//    val is = getClass.getResourceAsStream("/application.properties")
//    if (is != null) {
//      try {
//        val p = new Properties()
//        p.load(is)
//
//        p
//      } finally {
//        is.close()
//      }
//    } else {
//      new Properties()
//    }
//  }
//
////  protected val properties: Properties = getProperties
//
//  override def connParams: ConnParams = {
//    val properties = getProperties
//
//    val url: String = properties.getProperty("mq.url")
//    val userName: String = properties.getProperty("mq.userName")
//    val password: String = properties.getProperty("mq.password")
//
//    new ConnParams(url, userName, password)
//  }
//
//}
