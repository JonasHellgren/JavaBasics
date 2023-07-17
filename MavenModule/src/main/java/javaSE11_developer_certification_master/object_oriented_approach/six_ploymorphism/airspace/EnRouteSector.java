package javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace;

import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Coordinate;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Rectangle;

/*
En Route Sector
A polygon sector used for en route flights that happen
at cruise altitude

We are using rectangle for simplicity
 */
public class EnRouteSector implements AirSector {
    private int lowerAltitudeFl;
    private int upperAltitudeFl;
    private Rectangle shape;

    public EnRouteSector(Rectangle shape, int lowerAltitudeFl, int upperAltitudeFl) {
        this.shape = shape;
        this.lowerAltitudeFl = lowerAltitudeFl;
        this.upperAltitudeFl = upperAltitudeFl;
    }

    @Override
    public boolean isInSector(Coordinate x, int altitude) {
        if (altitude > this.upperAltitudeFl) {
            return false;
        }
        if (altitude < this.lowerAltitudeFl) {
            return false;
        }

        return shape.containsCoordinate(x);
    }
}
