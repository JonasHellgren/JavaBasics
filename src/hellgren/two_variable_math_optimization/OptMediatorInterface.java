package hellgren.two_variable_math_optimization;

import java.util.List;

public interface OptMediatorInterface {
    void run();
    void setDesignVariable();
    DesignVariable getDesignVariable();
    void addConstraint(Constraint constraint);
    void addConstraintCheckResults(boolean checkResult);
    List<Boolean> getConstraintCheckResults();

}
