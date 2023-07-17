package javaSE11_developer_certification_master.object_oriented_approach.five_encapsulation_and_inheritance.geography;

public abstract class Shape {
    public String toWkt() {
        String wkt = this.convertToWkt();

        if (this.isWktValid(wkt)) {
            return wkt;
        }
        throw new RuntimeException("Can not draw shape");
    }

    protected abstract String convertToWkt();

    private boolean isWktValid(String wkt) {
        if (wkt == null || wkt.length() == 0) {
            return false;
        }

        return wkt.startsWith("POINT") ||
                wkt.startsWith("LINESTRING") ||
                wkt.startsWith("POLYGON");
    }
}
