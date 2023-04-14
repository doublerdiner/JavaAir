import Individuals.Staff.Pilot;
import Individuals.Staff.RankType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    private Pilot pilot;

    @Before
    public void setup(){
        pilot = new Pilot("Adam", RankType.CAPTAIN, "AB12345");
    }

    @Test
    public void pilotHasName(){
        assertEquals("Adam", pilot.getName());
    }

    @Test
    public void pilotHasRank__NotFormatted(){
        assertEquals(RankType.CAPTAIN, pilot.getRankType());
    }
    @Test
    public void pilotHasRank__Formatted(){
        assertEquals("Captain", pilot.getRankType().getFormattedRank());
    }
    @Test
    public void pilotHasLicenceNumber(){
        assertEquals("AB12345", pilot.getLicenceNumber());
    }
    @Test
    public void pilotCanFly(){
        assertEquals("We are airborne! YEAAAAHHH", pilot.flyPlane());
    }
}
