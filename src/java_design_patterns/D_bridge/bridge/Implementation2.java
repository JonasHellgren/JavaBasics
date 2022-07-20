package java_design_patterns.D_bridge.bridge;

public class Implementation2 implements ImplementationInterface {
    @Override
    public void Function1() {
        System.out.println("Implementation2.F1");
    }

    @Override
    public void Function2() {
        System.out.println("Implementation2.F2");
    }
}
