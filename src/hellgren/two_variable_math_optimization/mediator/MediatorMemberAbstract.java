package hellgren.two_variable_math_optimization.mediator;

public class MediatorMemberAbstract implements MediatorMemberInterface {
    protected OptimizationMediatorInterface mediator;

    @Override
    public void setMediator(OptimizationMediatorInterface mediator){
        this.mediator = mediator;
    }
}
