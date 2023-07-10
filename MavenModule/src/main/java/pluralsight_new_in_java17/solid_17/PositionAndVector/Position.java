package pluralsight_new_in_java17.solid_17.PositionAndVector;

record Position (double x, double y){

    public Position applyVector(Vector v) {
        return new Position(x+v.dx(),y+v.dy());
    }
}
