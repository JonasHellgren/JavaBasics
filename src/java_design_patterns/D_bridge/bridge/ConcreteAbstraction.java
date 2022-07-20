package java_design_patterns.D_bridge.bridge;

public class ConcreteAbstraction implements Abstraction {
    public ImplementationInterface implementation;

    public ConcreteAbstraction(ImplementationInterface implementation)
    {
        this.implementation = implementation;
    }

    public void CallMethod1()
    {
        this.implementation.Function1();
    }

    public void CallMethod2()
    {
        this.implementation.Function2();
    }
}
