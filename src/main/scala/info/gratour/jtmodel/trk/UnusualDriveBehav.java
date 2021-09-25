package info.gratour.jtmodel.trk;

public class UnusualDriveBehav {
    private short typ;
    private byte tiredLvl;

    public short getTyp() {
        return typ;
    }

    public void setTyp(short typ) {
        this.typ = typ;
    }

    public byte getTiredLvl() {
        return tiredLvl;
    }

    public void setTiredLvl(byte tiredLvl) {
        this.tiredLvl = tiredLvl;
    }

    @Override
    public String toString() {
        return "UnusualDriveBehavior{" +
                "typ=" + typ +
                ", tiredLvl=" + tiredLvl +
                '}';
    }
}
