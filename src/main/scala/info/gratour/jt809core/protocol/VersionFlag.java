package info.gratour.jt809core.protocol;

public class VersionFlag {

    private int major;
    private int minor;
    private int revision;

    public VersionFlag() {
    }

    public VersionFlag(byte[] versionFlag, int offset) {
        major = versionFlag[offset];
        minor = versionFlag[offset + 1];
        revision = versionFlag[offset + 2] & 0xFF;
    }

    public int getMajor() {
        return major;
    }

    public void setMajor(int major) {
        this.major = major;
    }

    public int getMinor() {
        return minor;
    }

    public void setMinor(int minor) {
        this.minor = minor;
    }

    public int getRevision() {
        return revision;
    }

    public void setRevision(int revision) {
        this.revision = revision;
    }

    @Override
    public String toString() {
        return "V" + major + "." + minor + "." + revision;
    }
}
