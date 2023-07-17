package javaSE11_developer_certification_master.object_oriented_approach.five_encapsulation_and_inheritance.geography;

public final class Waypoint extends Shape {
    private final String name;
    private final LatLon position;

    public Waypoint(String name, LatLon position) {
        this.name = name;
        this.position = position;
    }

    @Override
    protected String convertToWkt() {
        StringBuilder sb = new StringBuilder();
        sb.append("POINT (")
                .append(this.position.getLon())
                .append(" ")
                .append(this.position.getLat())
                .append(")");

        return sb.toString();
    }
}
