package javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism;


import javaSE11_developer_certification_master.object_oriented_approach.enum_nested_classes.aircraft.Aircraft;
import javaSE11_developer_certification_master.object_oriented_approach.enum_nested_classes.aircraft.WakeTurbulence;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace.AirSector;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace.EnRouteSector;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.airspace.TMASector;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Circle;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Coordinate;
import javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography.Rectangle;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Define sectors with bad weather
        List<AirSector> sectorsWithBadWeather = List.of(
                new TMASector(
                        new Circle(new Coordinate(20, 20), 10),
                        100),
                new EnRouteSector(
                        new Rectangle(
                                new Coordinate(0, 0),
                                new Coordinate(10, 20),
                                new Coordinate(0, 20),
                                new Coordinate(10, 0)),
                        200, 400));

        // Define aircraft
        List<Aircraft> flyingAircraft = List.of(
                new Aircraft(1000, "B737", WakeTurbulence.LIGHT),
                new Aircraft(1001, "A320", WakeTurbulence.LIGHT),
                new Aircraft(1002, "A330", WakeTurbulence.MEDIUM)
        );


        // OS876 in TMA,
        // RO345 in EnRoute
        sectorsWithBadWeather.forEach(s -> {
            flyingAircraft.forEach(a -> {
            //    if (s.isInSector(a.getCoordinate(), a.getAltitudeFl())) {
             //       System.out.println("WARNING -> " + a.getCallSign() + " in bad weather sector");
             //   }
            });
        });

        // OS876 in TMA,
        // RO345 in EnRoute
        sectorsWithBadWeather.forEach(c -> System.out.println(c.isCrowded(1, 10)));
    }
}
