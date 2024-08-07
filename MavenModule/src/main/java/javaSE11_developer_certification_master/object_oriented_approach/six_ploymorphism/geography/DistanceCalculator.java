package javaSE11_developer_certification_master.object_oriented_approach.six_ploymorphism.geography;

public interface DistanceCalculator {
    static double calculate(Coordinate c1, Coordinate c2){
        return Math.sqrt(
                Math.pow((c1.getX() - c2.getX()), 2) +
                        Math.pow((c1.getY() - c2.getY()), 2)
        );
    }
}
