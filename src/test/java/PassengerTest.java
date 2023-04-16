import Individuals.Passenger.Passenger;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void flightCanBeAssignedToPassenger(){
        passenger.setFlight("AB12344");
        assertEquals("AB12344", passenger.getFlight());
    }

    @Test
    public void passengerCanBeGivenSeatNumber(){
        passenger.setSeatNumber(2);
        assertEquals(2, passenger.getSeatNumber());
    }

}
