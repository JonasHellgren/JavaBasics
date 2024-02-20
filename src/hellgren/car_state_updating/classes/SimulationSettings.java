package hellgren.car_state_updating.classes;

public record SimulationSettings(double deltaTime) {

    public static SimulationSettings newDefault() {
        return new SimulationSettings(1);
    }

}
