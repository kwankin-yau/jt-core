package info.gratour.jt809core;

import info.gratour.common.Consts;
import org.junit.Test;
import java.time.OffsetDateTime;

public class JT809TimeTest {

    @Test
    public void test() {
        OffsetDateTime odt = OffsetDateTime.of(2010, 1, 10, 9, 7, 54, 0, Consts.ZONE_OFFSET_BEIJING);
        System.out.println(odt.toEpochSecond());
    }
}
