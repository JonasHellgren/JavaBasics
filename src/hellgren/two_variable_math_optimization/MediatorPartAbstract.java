package hellgren.two_variable_math_optimization;

public class MediatorPartAbstract implements PartInterface {
    protected OptMediatorInterface mediator;

    @Override
    public void setMediator(OptMediatorInterface mediator){
        this.mediator = mediator;
    }
}
