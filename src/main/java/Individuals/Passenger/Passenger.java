package Individuals.Passenger;

import Individuals.Person;

public class Passenger extends Person {

    private int numberOfBags;

    public Passenger(String name, int numberOfBags){
        super(name);
        this.numberOfBags = numberOfBags;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

}
