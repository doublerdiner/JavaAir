import Individuals.Staff.CabinCrewMember;
import Individuals.Staff.RankType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewMemberTest {

    private CabinCrewMember cabinCrewMember;

    @Before
    public void setup(){
        cabinCrewMember = new CabinCrewMember("Tony", RankType.CAPTAIN);
    }

    @Test
    public void cabinCrewMemberHasName(){
        assertEquals("Tony", cabinCrewMember.getName());
    }

    @Test
    public void cabinCrewMemberHasRank__NotFormatted(){
        assertEquals(RankType.CAPTAIN, cabinCrewMember.getRankType());
    }

    @Test
    public void cabinCrewMemberHasRank__Formatted(){
        assertEquals("Captain", cabinCrewMember.getRankType().getFormattedRank());
    }

}
