package java_design_patterns.G_mediator.wash;

public class PartAbstract implements PartInterface {
    protected MachineMediator mediator;

    @Override
    public void setMediator(MachineMediator mediator){
        this.mediator = mediator;
    }
}
