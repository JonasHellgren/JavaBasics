package java_design_patterns.G_mediator.wash;

public class Machine extends PartAbstract {

    public void start(){
        mediator.openWaterValve();
    }

    public void wash(){
        mediator.wash();
    }
}