import Individuals.Passenger.Passenger;
import Individuals.Staff.CabinCrewMember;
import Individuals.Staff.Pilot;
import Individuals.Staff.RankType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private Plane plane;
    private Pilot pilot;
    private CabinCrewMember crew;
    private CabinCrewMember crew2;
    private Passenger passenger;

    @Before
    public void setup() {
        crew = new CabinCrewMember("Charlie", RankType.FLIGHT_ATTENDANT);
        crew2 = new CabinCrewMember("Sally", RankType.PURSER);
        passenger = new Passenger("Claire", 2);
        pilot = new Pilot("Eve", RankType.CAPTAIN, "EV55555");
        plane = new Plane(PlaneType.STARR_BUMBLE_BEE_II);
        flight = new Flight(plane, "AB123", DestinationType.JFK, DestinationType.DND, "1920", pilot);
        flight.addCrewMember(crew);
    }

    @Test
    public void flightHasAPlane(){
        assertEquals(PlaneType.STARR_BUMBLE_BEE_II, flight.getPlane().getPlaneType());
        assertEquals("Bumble Bee", flight.getPlane().getPlaneType().getFormattedPlane());
        assertEquals(5, flight.getPlane().getPlaneType().getSeats());
        assertEquals(200, flight.getPlane().getPlaneType().getWeight(), 0.01);
    }
    @Test
    public void flightHasFlightNumber(){
        assertEquals("AB123", flight.getFlightNumber());
    }
    @Test
    public void flightHasDestination(){
        assertEquals(DestinationType.JFK, flight.getDestination());
        assertEquals("New York JFK", flight.getDestination().getFormattedDestination());
    }
    @Test
    public void flightHasDepartingAirport(){
        assertEquals(DestinationType.DND, flight.getDeparture());
        assertEquals("Dundee", flight.getDeparture().getFormattedDestination());
    }
    @Test
    public void flightHasDepartureTime(){
        assertEquals("1920", flight.getDepartureTime());
    }
    @Test
    public void flightHasPilot(){
        assertEquals("Eve", flight.getPilot().getName());
        assertEquals(RankType.CAPTAIN, flight.getPilot().getRankType());
        assertEquals("Captain", flight.getPilot().getRankType().getFormattedRank());
        assertEquals("EV55555", flight.getPilot().getLicenceNumber());
    }
    @Test
    public void flightCanAddCrew(){
        assertEquals(1, flight.getCrew().size());
        assertEquals("Charlie", flight.getCrew().get(0).getName());
        assertEquals("Flight Attendant", flight.getCrew().get(0).getRankType().getFormattedRank());
    }
    @Test
    public void flightCanRemoveCrew(){
        flight.addCrewMember(crew2);
        flight.removeCrewMember(crew);
        assertEquals(1, flight.getCrew().size());
        assertEquals("Sally", flight.getCrew().get(0).getName());
        assertEquals("Purser", flight.getCrew().get(0).getRankType().getFormattedRank());
    }
    @Test
    public void flightCanReturnNumberOfAvailableSeats(){
        int answer = flight.freeSeats();
        assertEquals(5, answer);
    }
    @Test
    public void flightCanAddPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
        assertEquals("Claire", flight.getPassengers().get(0).getName());
    }
    @Test
    public void flightCannotAddPassengerBeyondSeatLimit(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        assertEquals(5, flight.getPassengers().size());
        flight.addPassenger(passenger);
        assertEquals(5, flight.getPassengers().size());
    }
    @Test
    public void flightCanRemovePassenger(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.removePassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
    }
    @Test
    public void flightCanTakeToTheSky(){
        assertEquals("We are airborne! YEAAAAHHH", flight.takeOff());
    }
}
