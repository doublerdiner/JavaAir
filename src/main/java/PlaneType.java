public enum PlaneType {
    STARR_BUMBLE_BEE_II("Bumble Bee", 5, 200),
    CESSNA_CITATION_560("Cessna C5", 8, 4261),
    BOEING_747("Boeing 747", 423, 183500);

    private final String formattedPlane;
    private final int seats;
    private final double weight;

    PlaneType(String formattedPlane, int seats, double weight) {
        this.formattedPlane = formattedPlane;
        this.seats = seats;
        this.weight = weight;
    }

    public String getFormattedPlane() {
        return formattedPlane;
    }

    public int getSeats() {
        return seats;
    }

    public double getWeight() {
        return weight;
    }
}
