package java_design_patterns.G_mediator.wash;

public class Valve extends PartAbstract {
    public void open(){
        System.out.println("Valve is opened...");
        System.out.println("Filling water...");
        mediator.closeWaterValve();
    }

    public void closed(){
        System.out.println("Valve is closed...");
        mediator.on();
    }
}
