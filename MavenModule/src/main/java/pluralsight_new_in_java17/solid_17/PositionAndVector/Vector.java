package pluralsight_new_in_java17.solid_17.PositionAndVector;

record Vector (double dx, double dy){

    public Vector reversed() {
        return new Vector(-dx(),-dy());
    }
}
