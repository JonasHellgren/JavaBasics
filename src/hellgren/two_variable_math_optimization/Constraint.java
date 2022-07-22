package hellgren.two_variable_math_optimization;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class Constraint  extends MediatorPartAbstract {

    double x1Max;
    double x2Max;
    double sumMax;

    abstract void  check();

}
