package info.gratour.jtmodel.trk;

public class OverSpdAddt {

    private byte typ;
    private int areaId;

    public byte getTyp() {
        return typ;
    }

    public void setTyp(byte typ) {
        this.typ = typ;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "OverSpdAddt{" +
                "typ=" + typ +
                ", areaId=" + areaId +
                '}';
    }
}
