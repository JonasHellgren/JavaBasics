package hellgren.two_variable_math_optimization;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public abstract class Constraint  extends MediatorMemberAbstract {

    public static final int NOT_USED_NUMBER = 0;

    double x1Max;
    double x2Max;
    double sumMax;

    abstract boolean  check();

}
