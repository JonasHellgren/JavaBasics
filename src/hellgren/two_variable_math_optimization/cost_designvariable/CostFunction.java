package hellgren.two_variable_math_optimization.cost_designvariable;

import hellgren.two_variable_math_optimization.mediator.MediatorMemberAbstract;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CostFunction extends MediatorMemberAbstract {

    double kx1;
    double kx2;
    double c;

    public static CostFunction newEmptyCostFunction() {
        return new CostFunction(0,0,0) ;
    }

    public final double calculate() {
        DesignVariable x= mediator.getDesignVariable();
        return kx1*x.x1+kx2*x.x2+c;
    }

}
