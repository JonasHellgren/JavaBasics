package java_design_patterns.G_mediator.wash;

public class Button extends PartAbstract {


    public void press() {
        System.out.println("Button pressed.");
        mediator.start();
    }
}
