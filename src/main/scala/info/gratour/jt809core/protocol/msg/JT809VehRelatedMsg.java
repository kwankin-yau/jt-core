package info.gratour.jt809core.protocol.msg;

import info.gratour.adaptor.types.IPlateNoAndColor;
import info.gratour.common.utils.StringUtils;
import info.gratour.jt809core.codec.decoder.bodydecoder.VehAndDataType;
import info.gratour.jt809core.protocol.JT809Msg;
import info.gratour.jtcommon.JTUtils;
import info.gratour.jtmodel.VehBrief;

public class JT809VehRelatedMsg extends JT809Msg implements IPlateNoAndColor {

    private String vehicleNo;
    private byte vehicleColor;
    private int dataType;

    public void setVeh(VehAndDataType vehAndDataType) {
        vehicleNo = vehAndDataType.vehicleNo();
        vehicleColor = vehAndDataType.vehicleColor();
    }

    public void setVeh(IPlateNoAndColor plateNoAndColor) {
        vehicleNo = plateNoAndColor.getPlateNo();
        vehicleColor = (byte) plateNoAndColor.getPlateColor();
    }

    public void setVehAndDataType(VehAndDataType vehAndDataType) {
        vehicleNo = vehAndDataType.vehicleNo();
        vehicleColor = vehAndDataType.vehicleColor();
        dataType = vehAndDataType.dataType();
    }

    public VehAndDataType getVehAndDataType() {
        return new VehAndDataType(vehicleNo, vehicleColor, dataType);
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public byte getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(int vehicleColor) {
        this.vehicleColor = (byte) vehicleColor;
    }

    public void setVeh(VehBrief vehBrief) {
        setVehicleNo(vehBrief.getPlateNo());
        setVehicleColor(vehBrief.getPlateColor());
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String dataTypeToHex() {
        return StringUtils.intToHex(dataType, 4);
    }

    @Override
    public String toString() {
        return "JT809VehicleRelatedMsg{" +
                "vehicleNo='" + vehicleNo + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", dataType=" + JTUtils.intToHex(dataType, 4) +
                "} " + super.toString();
    }

    @Override
    public String getPlateNo() {
        return vehicleNo;
    }

    @Override
    public int getPlateColor() {
        return vehicleColor;
    }
}
