package info.gratour.jt809core.protocol;

import org.omg.CORBA.PUBLIC_MEMBER;

public class JT809MsgConsts {

    public static final class LinkMsgs {
        public static final int UP_CONNECT_REQ_1001 = 0x1001;
        public static final int UP_CONNECT_RSP_1002 = 0x1002;
        public static final int UP_DISCONNECT_REQ_1003 = 0x1003;
        public static final int UP_DISCONNECT_RSP_1004 = 0x1004;
        public static final int UP_LINKTEST_REQ_1005 = 0x1005;
        public static final int UP_LINKTEST_RSP_1006 = 0x1006;
        public static final int UP_DISCONNECT_INFORM_1007 = 0x1007;
        public static final int UP_CLOSELINK_INFORM_1008 = 0x1008;

        public static final int DOWN_CONNECT_REQ_9001 = 0x9001;
        public static final int DOWN_CONNECT_RSP_9002 = 0x9002;
        public static final int DOWN_DISCONNECT_REQ_9003 = 0x9003;
        public static final int DOWN_DISCONNECT_RSP_9004 = 0x9004;
        public static final int DOWN_LINKTEST_REQ_9005 = 0x9005;
        public static final int DOWN_LINKTEST_RSP_9006 = 0x9006;
        public static final int DOWN_DISCONNECT_INFORM_9007 = 0x9007;
        public static final int DOWN_CLOSELINK_INFORM_9008 = 0x9008;
    }

    public static final class ManageMsgs {
        public static final int UP_MANAGE_TOTAL_RECV_BACK_MSG_REV_9101_2019 = 0x9101;
        public static final int DOWN_MANAGE_TOTAL_RECV_BACK_MSG_9101 = 0x9101;
    }

    public static final class ExgMsgs {
        public static final int UP_EXG_MSG_1200 = 0x1200;
        public static final int DOWN_EXG_MSG_9200 = 0x9200;

        public static final int UP_EXG_MSG_REGISTER_1201 = 0x1201;
        public static final int UP_EXG_MSG_REAL_LOCATION_1202 = 0x1202;
        public static final int UP_EXG_MSG_HISTORY_LOCATION_1203 = 0x1203;
        public static final int UP_EXG_MSG_RETURN_STARTUP_ACK_1205 = 0x1205;
        public static final int UP_EXG_MSG_RETURN_END_ACK_1206 = 0x1206;
        public static final int UP_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_1207 = 0x1207;
        public static final int UP_EXG_MSG_APPLY_FOR_MONTIOR_END_1208 = 0x1208;
        public static final int UP_EXG_MSG_APPLY_HISGNSSDATA_REQ_1209 = 0x1209;
        public static final int UP_EXG_MSG_REPORT_DRIVER_INFO_ACK_120A = 0x120A;
        public static final int UP_EXG_MSG_TAKE_EWAYBILL_ACK_120B = 0x120B;

        public static final int UP_EXG_MSG_SAFETY_TERMINAL_1240__SICHUAN = 0x1240; // sichuan

        public static final int DOWN_EXG_MSG_CAR_LOCATION_9202 = 0x9202;
        public static final int DOWN_EXG_MSG_HISTORY_ACROSSAREA_9203 = 0x9203;
        public static final int DOWN_EXG_MSG_CAR_INFO_9204 = 0x9204;
        public static final int DOWN_EXG_MSG_RETURN_STARTUP_9205 = 0x9205;
        public static final int DOWN_EXG_MSG_RETURN_END_9206 = 0x9206;
        public static final int DOWN_EXG_MSG_APPLY_FOR_MONITOR_STARTUP_ACK_9207 = 0x9207;
        public static final int DOWN_EXG_MSG_APPLY_FOR_MONITOR_END_ACK_9208 = 0x9208;
        public static final int DOWN_EXG_MSG_APPLY_HISGNSSDATA_ACK_9209 = 0x9209;
        public static final int DOWN_EXG_MSG_REPORT_DRIVER_INFO_920A = 0x920A;
        public static final int DOWN_EXG_MSG_TAKE_EWAYBILL_REQ_920B = 0x920B;
    }

    public static final class PlatformMsgs {
        public static final int UP_PLATFORM_MSG_1300 = 0x1300;
        public static final int DOWN_PLATFORM_MSG_9300 = 0x9300;

        public static final int UP_PLATFORM_MSG_POST_QUERY_ACK_1301 = 0x1301;
        public static final int UP_PLATFORM_MSG_INFO_ACK_1302 = 0x1302;

        public static final int DOWN_PLATFORM_MSG_POST_QUERY_REQ_9301 = 0x9301;
        public static final int DOWN_PLATFORM_MSG_INFO_REQ_9302 = 0x9302;
    }

    public static final class WarnMsgs {
        public static final int UP_WARN_MSG_1400 = 0x1400;
        public static final int DOWN_WARN_MSG_9400 = 0x9400;

        public static final int UP_WARN_MSG_URGE_TODO_ACK_1401 = 0x1401;
        public static final int UP_WARN_MSG_ADPT_INFO_1402 = 0x1402;
        public static final int UP_WARN_MSG_SICHUAN_OPERATION_INFO_1403 = 0x1403; // sichuan
        public static final int UP_WARN_MSG_SICHUAN_FILELIST_ACK_1404 = 0x1404; // sichuan
        public static final int UP_WARN_MSG_SICHUAN_CHECK_ACK_1405 = 0x01405; // sichuan
        public static final int UP_WARN_MSG_SICHUAN_STATICS_ACK_1406 = 0x1406; // sichuan

        public static final int DOWN_WARN_MSG_URGE_TODO_REQ_9401 = 0x9401;
        public static final int DOWN_WARN_MSG_INFORM_TIPS_9402 = 0x9402;
        public static final int DOWN_WARN_MSG_EXG_INFORM_9403 = 0x9403;
        public static final int DOWN_WARN_MSG_SICHUAN_FILELIST_REQ_9404 = 0x9404; // sichuan
        public static final int DOWN_WARN_MSG_SICHUAN_CHECK_REQ_9405 = 0x9405; // sichuan
        public static final int DOWN_WARN_MSG_SICHUAN_STATICS_REQ_9406 = 0x9406; // sichuan
    }

    public static final class CtrlMsgs {
        public static final int UP_CTRL_MSG_1500 = 0x1500;
        public static final int DOWN_CTRL_MSG_9500 = 0x9500;

        public static final int UP_CTRL_MSG_MONITOR_VEHICLE_ACK_1501 = 0x1501;
        public static final int UP_CTRL_MSG_TAKE_PHOTO_ACK_1502 = 0x1502;
        public static final int UP_CTRL_MSG_TEXT_INFO_ACK_1503 = 0x1503;
        public static final int UP_CTRL_MSG_TAKE_TRAVEL_ACK_1504 = 0x1504;
        public static final int UP_CTRL_MSG_EMERGENCY_MONITORING_ACK_1505 = 0x1505;

        public static final int DOWN_CTRL_MSG_MONITOR_VEHICLE_REQ_9501 = 0x9501;
        public static final int DOWN_CTRL_MSG_TAKE_PHOTO_REQ_9502 = 0x9502;
        public static final int DOWN_CTRL_MSG_TEXT_INFO_REQ_9503 = 0x9503;
        public static final int DOWN_CTRL_MSG_TAKE_TRAVEL_REQ_9504 = 0x9504;
        public static final int DOWN_CTRL_MSG_EMERGENCY_MONITORING_REQ_9505 = 0x9505;
    }

    public static final class BaseMsgs {
        public static final int UP_BASE_MSG_1600 = 0x1600;
        public static final int DOWN_BASE_MSG_9600 = 0x9600;

        public static final int UP_BASE_MSG_VEHICLE_ADDED_ACK_1601 = 0x1601;
        public static final int DOWN_BASE_MSG_VEHICLE_ADDED_9601 = 0x9601;
    }

    public static final class AuthorizeMsgs {
        public static final int UP_AUTHORIZE_MSG_1700 = 0x1700;
        public static final int DOWN_AUTHORIZE_MSG_9700 = 0x9700;

        public static final int UP_AUTHORIZE_MSG_STARTUP_1701 = 0x1701;
        public static final int UP_AUTHORIZE_MSG_REQ_1702 = 0x1702;
        public static final int DOWN_AUTHORIZE_MSG_STARTUP_REQ_ACK_9702 = 0x9702;
    }

    public static final class RealVideoMsgs {
        public static final int UP_REALVIDEO_MSG_1800 = 0x1800;
        public static final int DOWN_REALVIDEO_MSG_9800 = 0x9800;

        public static final int DOWN_REALVIDEO_MSG_STARTUP_9801 = 0x9801;
        public static final int UP_REALVIDEO_MSG_STARTUP_ACK_1801 = 0x1801;
        public static final int DOWN_REALVIDEO_MSG_END_9802 = 0x9802;
        public static final int UP_REALVIDEO_MSG_END_ACK_1802 = 0x1802;
    }

    public static final class VideoFileListMsgs {
        public static final int UP_FILELIST_MSG_1900 = 0x1900;
        public static final int DOWN_FILELIST_MSG_9900 = 0x9900;

        public static final int UP_FILELIST_MSG_1901 = 0x1901;
        public static final int DOWN_FILELIST_MSG_ACK_9901 = 0x9901;
        public static final int DOWN_FILELIST_REQ_9902 = 0x9902;
        public static final int UP_FILELIST_REQ_ACK_1902 = 0x1902;
    }

    public static final class VideoPlaybackMsgs {
        public static final int UP_PLAYBACK_MSG_1A00 = 0x1A00;
        public static final int DOWN_PLAYBACK_MSG_9A00 = 0x9A00;

        public static final int DOWN_PLAYBACK_MSG_STARTUP_9A01 = 0x9A01;
        public static final int UP_PLAYBACK_MSG_STARTUP_ACK_1A01 = 0x1A01;
        public static final int DOWN_PLAYBACK_MSG_CONTROL_9A02 = 0x9A02;
        public static final int UP_PLAYBACK_MSG_CONTROL_ACK_1A02 = 0x1A02;
    }

    public static final class VideoDownloadMsgs {
        public static final int UP_DOWNLOAD_MSG_1B00 = 0x1B00;
        public static final int DOWN_DOWNLOAD_MSG_9B00 = 0x9B00;

        public static final int DOWN_DOWNLOAD_MSG_STARTUP_9B01 = 0x9B01;
        public static final int UP_DOWNLOAD_MSG_STARTUP_ACK_1B01 = 0x1B01;
        public static final int UP_DOWNLOAD_MSG_END_INFORM_1B02 = 0x1B02;
        public static final int DOWN_DOWNLOAD_MSG_END_INFORM_ACK_9B02 = 0x9B02;
        public static final int DOWN_DOWNLOAD_MSG_CONTROL_9B03 = 0x9B03;
        public static final int UP_DOWNLOAD_MSG_CONTROL_ACK_1B03 = 0x1B03;
    }
}
