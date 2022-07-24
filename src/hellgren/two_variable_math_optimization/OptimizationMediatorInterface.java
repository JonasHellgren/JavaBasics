package hellgren.two_variable_math_optimization;

import java.util.List;

public interface OptimizationMediatorInterface {
    void run();
    void setDesignVariable(DesignVariable designVariable);
    DesignVariable getDesignVariable();
    void addConstraint(ConstraintAbstract constraint);
    void addConstraintCheckResults(boolean checkResult);
    List<Boolean> getConstraintCheckResults();
    void setCostResult(double result);
    double getCostResult();
    boolean areConstraintsFeasible();

}
