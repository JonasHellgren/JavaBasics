package effective_java.F_enums_and_annotaitons.item37;

public class Plant {
    public enum LifeCycle {ANNUAL, PERENNIAL, BIENNIAL }

    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifecycle) {
        this.name = name;
        this.lifeCycle = lifecycle;
    }

    public LifeCycle getLifeCycle() {
        return lifeCycle;
    }

    @Override
    public String toString() {
        return name;
    }
}
