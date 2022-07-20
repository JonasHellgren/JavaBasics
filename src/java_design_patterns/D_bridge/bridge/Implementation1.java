package java_design_patterns.D_bridge.bridge;

public class Implementation1 implements ImplementationInterface {

    @Override
    public void Function1() {
        System.out.println("Implementation1.F1");
    }

    @Override
    public void Function2() {
        System.out.println("Implementation1.F2");
    }
}
