


Prefer static factory methods

    public static FlightSearchService newFlightSearchServiceEmptyStore() {
        return new FlightSearchService();
    }


makes test independent by for ex injecting mocked data


Check method parameters 

    private String checkValidDest(String fromDest) {  //added
        if (Objects.isNull(fromDest)) {
            throw new IllegalArgumentException();
        }
        return fromDest;
    }