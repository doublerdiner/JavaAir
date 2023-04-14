import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    private Plane plane;

    @Before
    public void setup(){
        plane = new Plane(PlaneType.STARR_BUMBLE_BEE_II);
    }

    @Test
    public void planeHasType__NotFormatted(){
        assertEquals(PlaneType.STARR_BUMBLE_BEE_II, plane.getPlaneType());
    }
    @Test
    public void planeHasType__Formatted(){
        assertEquals("Bumble Bee", plane.getPlaneType().getFormattedPlane());
    }
    @Test
    public void planeHasSeats(){
        assertEquals(5, plane.getPlaneType().getSeats());
    }
    @Test
    public void planeHasWeight(){
        assertEquals(200, plane.getPlaneType().getWeight(), 0.01);
    }

}
