package Individuals.Passenger;

import Individuals.Person;

public class Passenger extends Person {

    private int numberOfBags;
    private String flight;
    private Integer seatNumber;

    public Passenger(String name, int numberOfBags){
        super(name);
        this.numberOfBags = numberOfBags;
        this.flight = new String();
        this.seatNumber = null;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public String getFlight() {
        return flight;
    }
    public void setFlight(String flight) {
        this.flight = flight;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    public void setSeatNumber(Integer seatNumber) {
        this.seatNumber = seatNumber;
    }

}
