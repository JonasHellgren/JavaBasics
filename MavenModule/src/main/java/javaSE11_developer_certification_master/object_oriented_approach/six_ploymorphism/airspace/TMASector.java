package javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace;


import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Circle;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Coordinate;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.DistanceCalculator;

/*
Terminal Maneuvering Area
An elliptical/circular sector used near airports for landing / departures
We are using circle for simplicity
 */
public class TMASector implements AirSector {
    private Circle shape;
    private int upperAltitudeFl;

    public TMASector(Circle shape, int upperAltitudeFl) {
        this.shape = shape;
        this.upperAltitudeFl = upperAltitudeFl;
    }

    @Override
    public boolean isInSector(Coordinate x, int altitude) {
        if (altitude > this.upperAltitudeFl) {
            return false;
        }
        double distanceToRadius =
                DistanceCalculator.calculate(x, this.shape.getOrigin());
        return distanceToRadius < this.shape.getRadiusNm();
    }
}
