package Individuals.Staff;

import Individuals.Person;

public class CabinCrewMember extends Person {
    private RankType rankType;
    public CabinCrewMember(String name, RankType rankType){
        super(name);
        this.rankType = rankType;
    }
    public RankType getRankType() {
        return rankType;
    }
}
