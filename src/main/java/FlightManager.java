import Individuals.Passenger.Passenger;

public class FlightManager {
    private Flight flight;

    public FlightManager(Flight flight){
        this.flight = flight;
    }

    public Flight getFlight() {
        return flight;
    }

    public double baggageWeightAvailablePerPassenger(){
        int seats =  this.flight.getPlane().getSeats();
        double weight = this.flight.getPlane().getWeight();
        return (weight / 2) / seats;
    }

    public double passengersBaggageWeight() {
        double total = 0;
        for(Passenger passenger : this.flight.getPassengers()){
            total += (passenger.getNumberOfBags() * 20);
        }
        return total;
    }

    public String calculateRemainingBaggageAllowance() {
        double weight = this.flight.getPlane().getWeight() / 2;
        if(passengersBaggageWeight() > weight){
            double calculation = passengersBaggageWeight() - weight;
            return String.format("Warning! Flight is over the baggage limit by %skg!", calculation);
        }
        else{
            double calculation = weight - passengersBaggageWeight();
            return String.format("%skg remaining", calculation);
        }
    }
}
