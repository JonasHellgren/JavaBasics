package javaSE11_developer_certification_master.object_oriented_approach.two_classes_and_objects.main;

import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Partial flight plan
        FlightPlan berlinToBucharest = new FlightPlan(
                "BER",
                "OTP"
        );
        berlinToBucharest.print();

        System.out.println();

        // Complete flight plan
        FlightPlan parisToLondon = new FlightPlan(
                "CDG",
                "LHR",
                LocalDateTime.of(2020, 01, 10, 23, 15),
                List.of("CDG", "FARAR", "BAYKA", "DUDES", "LHR")
        );
        parisToLondon.print();
    }
}
