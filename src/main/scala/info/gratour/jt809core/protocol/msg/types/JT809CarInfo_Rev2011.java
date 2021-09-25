package info.gratour.jt809core.protocol.msg.types;

/**
 * JT809-2011, table 71 vehicle static information structure
 */
public class JT809CarInfo_Rev2011 {
    private String transType;
    private String vin;
    private String traction;
    private String trailerVin;
    private String vehicleNationality;
    private String vehicleType;
    private String rtpn;
    private String ownersName;
    private String ownersOrigId;
    private String ownersTel;
    private String rtoln;
    private String vehicleMode;
    private byte vehicleColor;
    private String vehicleOrigId;
    private String driverInfo;
    private String businessArea;
    private String banLineType;
    private String approvedSeats;
    private String orgin;
    private String destination;
    private String departureSt;
    private String destSt;

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getTraction() {
        return traction;
    }

    public void setTraction(String traction) {
        this.traction = traction;
    }

    public String getTrailerVin() {
        return trailerVin;
    }

    public void setTrailerVin(String trailerVin) {
        this.trailerVin = trailerVin;
    }

    public String getVehicleNationality() {
        return vehicleNationality;
    }

    public void setVehicleNationality(String vehicleNationality) {
        this.vehicleNationality = vehicleNationality;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRtpn() {
        return rtpn;
    }

    public void setRtpn(String rtpn) {
        this.rtpn = rtpn;
    }

    public String getOwnersName() {
        return ownersName;
    }

    public void setOwnersName(String ownersName) {
        this.ownersName = ownersName;
    }

    public String getOwnersOrigId() {
        return ownersOrigId;
    }

    public void setOwnersOrigId(String ownersOrigId) {
        this.ownersOrigId = ownersOrigId;
    }

    public String getOwnersTel() {
        return ownersTel;
    }

    public void setOwnersTel(String ownersTel) {
        this.ownersTel = ownersTel;
    }

    public String getRtoln() {
        return rtoln;
    }

    public void setRtoln(String rtoln) {
        this.rtoln = rtoln;
    }

    public String getVehicleMode() {
        return vehicleMode;
    }

    public void setVehicleMode(String vehicleMode) {
        this.vehicleMode = vehicleMode;
    }

    public byte getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(byte vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleOrigId() {
        return vehicleOrigId;
    }

    public void setVehicleOrigId(String vehicleOrigId) {
        this.vehicleOrigId = vehicleOrigId;
    }

    public String getDriverInfo() {
        return driverInfo;
    }

    public void setDriverInfo(String driverInfo) {
        this.driverInfo = driverInfo;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getBanLineType() {
        return banLineType;
    }

    public void setBanLineType(String banLineType) {
        this.banLineType = banLineType;
    }

    public String getApprovedSeats() {
        return approvedSeats;
    }

    public void setApprovedSeats(String approvedSeats) {
        this.approvedSeats = approvedSeats;
    }

    public String getOrgin() {
        return orgin;
    }

    public void setOrgin(String orgin) {
        this.orgin = orgin;
    }

    @Override
    public String toString() {
        return "JT809CarInfo{" +
                "transType='" + transType + '\'' +
                ", vin='" + vin + '\'' +
                ", traction='" + traction + '\'' +
                ", trailerVin='" + trailerVin + '\'' +
                ", vehicleNationality='" + vehicleNationality + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", rtpn='" + rtpn + '\'' +
                ", ownersName='" + ownersName + '\'' +
                ", ownersOrigId='" + ownersOrigId + '\'' +
                ", ownersTel='" + ownersTel + '\'' +
                ", rtoln='" + rtoln + '\'' +
                ", vehicleMode='" + vehicleMode + '\'' +
                ", vehicleColor=" + vehicleColor +
                ", vehicleOrigId='" + vehicleOrigId + '\'' +
                ", driverInfo='" + driverInfo + '\'' +
                ", businessArea='" + businessArea + '\'' +
                ", banLineType='" + banLineType + '\'' +
                ", approvedSeats='" + approvedSeats + '\'' +
                ", orgin='" + orgin + '\'' +
                ", destination='" + destination + '\'' +
                ", departureSt='" + departureSt + '\'' +
                ", destSt='" + destSt + '\'' +
                '}';
    }
}
