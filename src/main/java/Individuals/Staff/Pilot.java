package Individuals.Staff;

public class Pilot extends CabinCrewMember{

    private String licenceNumber;

    public Pilot(String name, RankType rankType, String licenceNumber){
        super(name, rankType);
        this.licenceNumber = licenceNumber;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }
}
