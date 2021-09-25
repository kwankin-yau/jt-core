package info.gratour.adaptor;

public interface GnssAdaptor {
    SysRepo sysRepo();
    GnssGrpRepo grpRepo();
    TermRepo termRepo();
    TermCmdRepo termCmdRepo();
    MediaRepo mediaRepo();
    AlmRepo almRepo();
    VehRepo vehRepo();
    AVResRepo avResRepo();
    GovIssueRepo govIssueRepo();
    RtRgnRepo rtRgnRepo();
    StrmMediaRepo strmMediaRepo();
}

