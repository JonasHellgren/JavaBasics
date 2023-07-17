package javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace;


import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Coordinate;

public interface AirSector {
    boolean isInSector(Coordinate x, int altitude);

    default boolean isCrowded(int aircraft, int maxNbAircraft) {
        return aircraft > maxNbAircraft;
    }
}
