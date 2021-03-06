/*******************************************************************************
 *  Copyright (c) 2019, 2020 lucendar.com.
 *  All rights reserved.
 *
 *  Contributors:
 *     KwanKin Yau (alphax@vip.163.com) - initial API and implementation
 *******************************************************************************/
package info.gratour.jt808core.protocol.msg.types.cmdparams;

import info.gratour.jt808core.protocol.JT1078MsgConsts;
import info.gratour.jtcommon.JTMsgId;

@JTMsgId(JT1078MsgConsts.LIVE_AV_REQ_9101)
public class CP_9101_LiveAVReq implements JT808CmdParams {

    public static final byte DATA_TYPE__AV = 0;
    public static final byte DATA_TYPE__VIDEO = 1;
    public static final byte DATA_TYPE__TALK = 2;
    public static final byte DATA_TYPE__LISTEN = 3;
    public static final byte DATA_TYPE__BROADCAST = 4;
    public static final byte DATA_TYPE__PASS_THOUGH = 5;

    public static final byte CODE_STREAM__PRIMARY = 0;
    public static final byte CODE_STREAM__SUB = 1;

    private String serverIp;
    private int tcpPort;
    private int udpPort;
    private byte channel;
    private Byte dataType;
    private Byte codeStream;
    private int debug;
    private String serverId;

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public int getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(int tcpPort) {
        this.tcpPort = tcpPort;
    }

    public int getUdpPort() {
        return udpPort;
    }

    public void setUdpPort(int udpPort) {
        this.udpPort = udpPort;
    }

    public byte getChannel() {
        return channel;
    }

    public void setChannel(byte channel) {
        this.channel = channel;
    }

    public Byte getDataType() {
        return dataType;
    }

    public void setDataType(Byte dataType) {
        this.dataType = dataType;
    }

    public Byte getCodeStream() {
        return codeStream;
    }

    public void setCodeStream(Byte codeStream) {
        this.codeStream = codeStream;
    }

    public byte getDataTypeDef() {
        if (dataType != null)
            return dataType;
        else
            return DATA_TYPE__AV;
    }

    public byte getCodeStreamDef() {
        if (codeStream != null)
            return codeStream;
        else
            return CODE_STREAM__PRIMARY;
    }

    public int getDebug() {
        return debug;
    }

    public void setDebug(int debug) {
        this.debug = debug;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    @Override
    public String toString() {
        return "CP_9101_LiveAVReq{" +
                "serverIp='" + serverIp + '\'' +
                ", tcpPort=" + tcpPort +
                ", udpPort=" + udpPort +
                ", channel=" + channel +
                ", dataType=" + dataType +
                ", codeStream=" + codeStream +
                ", debug=" + debug +
                ", serverId='" + serverId + '\'' +
                '}';
    }
}
