import Individuals.Passenger.Passenger;
import Individuals.Staff.CabinCrewMember;
import Individuals.Staff.Pilot;

import java.sql.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Flight {
    private Plane plane;
    private String flightNumber;
    private DestinationType destination;
    private DestinationType departure;
    private LocalDateTime departureTime;
    private Pilot pilot;
    private ArrayList<CabinCrewMember> crew;
    private ArrayList<Passenger> passengers;
    private ArrayList<Integer> seats;

    public Flight(Plane plane, String flightNumber, DestinationType destination, DestinationType departure, LocalDateTime departureTime, Pilot pilot) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departure = departure;
        this.departureTime = departureTime;
        this.pilot = pilot;
        this.crew = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.seats = new ArrayList<Integer>();
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

    public LocalDateTime getDepartureTime() {
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

    public ArrayList<Integer> getSeats() {
        return seats;
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
            passenger.setSeatNumber(generatePassengerSeatNumber());
           this.passengers.add(passenger);
           passenger.setFlight(this.flightNumber);
        }
    }

    public void removePassenger(Passenger passenger) {
        this.passengers.remove(passenger);
        passenger.setFlight(new String());
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

    public void setSeats(){
        for (int i=0; i<this.plane.getPlaneType().getSeats(); i++){
            this.seats.add(i+1);
        }
    }

    public int generatePassengerSeatNumber(){
        if(this.passengers.size() == 0) {
            setSeats();
        }
        int index = (int)(Math.random() * this.seats.size());
        return this.seats.remove(index);
    }

}
