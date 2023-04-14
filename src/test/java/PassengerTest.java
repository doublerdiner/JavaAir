import Individuals.Passenger.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void setup(){
        passenger = new Passenger("Aimi", 2);
    }

    @Test
    public void passengerHasName(){
        assertEquals("Aimi", passenger.getName());
    }

    @Test
    public void passengerHasBags(){
        assertEquals(2, passenger.getNumberOfBags());
    }

}
