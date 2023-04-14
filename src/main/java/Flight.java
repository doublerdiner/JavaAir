import Individuals.Passenger.Passenger;
import Individuals.Staff.CabinCrewMember;
import Individuals.Staff.Pilot;

import java.util.ArrayList;
import java.util.HashMap;

public class Flight {
    private Plane plane;
    private String flightNumber;
    private DestinationType destination;
    private DestinationType departure;
    private String departureTime;
    private Pilot pilot;
    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;

    public Flight(Plane plane, String flightNumber, DestinationType destination, DestinationType departure, String departureTime, Pilot pilot) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.pilot = pilot;
        this.crew = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    public PlaneType getPlane() {
        return this.plane.getPlaneType();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public DestinationType getDestination() {
        return destination;
    }

    public DestinationType getDeparture() {
        return departure;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public Pilot getPilot() {
        return pilot;
    }

    public ArrayList<CabinCrewMember> getCrew() {
        return crew;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public void addCrewMember(CabinCrewMember crew) {
        this.crew.add(crew);
    }

    public void removeCrewMember(CabinCrewMember crew) {
        this.crew.remove(crew);
    }

    public int freeSeats() {
        return this.plane.getPlaneType().getSeats() - this.passengers.size();
    }

    public void addPassenger(Passenger passenger) {
        if(freeSeats() > 0){
           this.passengers.add(passenger);
        }
    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
    }

    public String takeOff() {
        return this.getPilot().flyPlane();
    }

    public CabinCrewMember findFlightAttendant(){
        for(CabinCrewMember crew : this.crew){
            if(crew.getRankType().getFormattedRank() == "Flight Attendant"){
                return crew;
            }
        }
        return null;
    }

    public String cabinCrewTalkToPassengers(){
        String total = "";
        CabinCrewMember crew = findFlightAttendant();
        for (Passenger passenger : this.passengers){
            total += crew.speak() + " ";
        }
        return total;
    }

}
