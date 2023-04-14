package Individuals.Staff;

public enum RankType {
    CAPTAIN("Captain"),
    FIRST_OFFICER("First Officer"),
    PURSER("Purser"),
    FLIGHT_ATTENDANT("Flight Attendant");

    private final String formattedRank;

    RankType(String formattedRank) {
        this.formattedRank = formattedRank;
    }
    public String getFormattedRank() {
        return formattedRank;
    }
}
