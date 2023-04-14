public enum DestinationType {
    GLA("Glasgow"),
    EDI("Edinburgh"),
    DND("Dundee"),
    LGW("London Gatwick"),
    LTN("London Luton"),
    LHR("London Heathrow"),
    LAX("Los Angeles Airport"),
    JFK("New York JFK"),
    ORD("Chicago");

    private final String formattedDestination;

    DestinationType(String formattedDestination) {
        this.formattedDestination = formattedDestination;
    }

    public String getFormattedDestination() {
        return formattedDestination;
    }
}
