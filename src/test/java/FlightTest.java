import Individuals.Passenger.Passenger;
import Individuals.Staff.CabinCrewMember;
import Individuals.Staff.Pilot;
import Individuals.Staff.RankType;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private CabinCrewMember crew;
    private CabinCrewMember crew2;
    private Passenger passenger;

    @Before
    public void setup() {
        crew = new CabinCrewMember("Charlie", RankType.FLIGHT_ATTENDANT);
        crew2 = new CabinCrewMember("Sally", RankType.PURSER);
        passenger = new Passenger("Claire", 2);
        Pilot pilot = new Pilot("Eve", RankType.CAPTAIN, "EV55555");
        Plane plane = new Plane(PlaneType.STARR_BUMBLE_BEE_II);
        flight = new Flight(plane, "AB123", DestinationType.JFK, DestinationType.DND, LocalDateTime.of(2023, Month.APRIL, 16, 6,30), pilot);
        flight.addCrewMember(crew);
    }

    @Test
    public void flightHasAPlane(){
        assertEquals(PlaneType.STARR_BUMBLE_BEE_II, flight.getPlane());
        assertEquals("Bumble Bee", flight.getPlane().getFormattedPlane());
        assertEquals(5, flight.getPlane().getSeats());
        assertEquals(200, flight.getPlane().getWeight(), 0.01);
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
        assertEquals("2023-04-16T06:30", flight.getDepartureTime().toString());
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
    public void flightCanAddFlightNumberToPassenger(){
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
        assertEquals("AB123", passenger.getFlight());
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
    public void flightCanRemoveFlightNumberFromPassenger(){
        flight.addPassenger(passenger);
        assertEquals("AB123", passenger.getFlight());
        flight.removePassenger(passenger);
        assertEquals(0, flight.getPassengers().size());
        assertEquals("", passenger.getFlight());
    }
    @Test
    public void flightCanTakeToTheSky(){
        assertEquals("We are airborne! YEAAAAHHH", flight.takeOff());
    }
    @Test
    public void flightAttendantWillTalkToAllPassengers(){
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addPassenger(passenger);
        flight.addCrewMember(crew2);
        assertEquals("Would you like anything to drink? Would you like anything to drink? Would you like anything to drink? ", flight.cabinCrewTalkToPassengers());
    }

    @Test
    public void setTheSeatsForFlight(){
        flight.setSeats();
        assertEquals(5, flight.getSeats().size());
    }
    @Test
    public void passengerGivenUniqueSeatNumberWhenAddedToFlight(){
        flight.addPassenger(passenger);
        System.out.println(passenger.getSeatNumber());
        Passenger passenger2 = new Passenger("Barry", 1);
        flight.addPassenger(passenger2);
        System.out.println(passenger2.getSeatNumber());
        Passenger passenger3 = new Passenger("Terry", 1);
        flight.addPassenger(passenger3);
        System.out.println(passenger3.getSeatNumber());
        Passenger passenger4 = new Passenger("Harry", 1);
        flight.addPassenger(passenger4);
        System.out.println(passenger4.getSeatNumber());
        Passenger passenger5 = new Passenger("Gary", 1);
        flight.addPassenger(passenger5);
        System.out.println(passenger5.getSeatNumber());
        Set<Object> set = new HashSet<>();
        set.add(passenger.getSeatNumber());
        set.add(passenger2.getSeatNumber());
        set.add(passenger3.getSeatNumber());
        set.add(passenger4.getSeatNumber());
        set.add(passenger5.getSeatNumber());
        assertEquals(5, flight.getPassengers().size());
        assertEquals(5, set.size());
    }
}
