import Individuals.Passenger.Passenger;
import Individuals.Staff.Pilot;
import Individuals.Staff.RankType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    private FlightManager flightManager;
    private Flight flight;
    private Plane plane;
    private Pilot pilot;
    private Passenger passenger;
    private Passenger passenger2;

    @Before
    public void setup(){
        passenger = new Passenger("Bunty", 1);
        passenger2 = new Passenger("Betty", 8);
        pilot = new Pilot("Sheila", RankType.CAPTAIN, "SH98765");
        plane = new Plane(PlaneType.STARR_BUMBLE_BEE_II);
        flight = new Flight(plane, "BA54321", DestinationType.LAX, DestinationType.EDI, "2000", pilot);
        flightManager = new FlightManager(flight);
    }

    @Test
    public void flightManagerHasFlight(){
        assertEquals("Sheila", flightManager.getFlight().getPilot().getName());
        assertEquals("BA54321", flightManager.getFlight().getFlightNumber());
        assertEquals("Los Angeles Airport", flightManager.getFlight().getDestination().getFormattedDestination());
        assertEquals("Edinburgh", flightManager.getFlight().getDeparture().getFormattedDestination());
    }
    @Test
    public void calculateBaggageAllowancePerPassenger(){
        assertEquals(20, flightManager.baggageWeightAvailablePerPassenger(), 0.01);
    }

    @Test
    public void calculateBaggageWeightOfPassengers(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals(60, flightManager.passengersBaggageWeight(), 0.01);
        flight.addPassenger(passenger2);
        assertEquals(220, flightManager.passengersBaggageWeight(), 0.01);
    }
    @Test
    public void calculateRemainingBaggageAllowanceOnFlight(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals("40.0kg remaining", flightManager.calculateRemainingBaggageAllowance());
    }
    @Test
    public void calculateRemainingBaggageAllowanceOnFlight__TooMuchBaggage(){
        flight.addPassenger(passenger2);
        assertEquals("Warning! Flight is over the baggage limit by 60.0kg!", flightManager.calculateRemainingBaggageAllowance());
    }



}
