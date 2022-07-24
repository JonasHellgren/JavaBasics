package hellgren.two_variable_math_optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * Following fields will have access to the mediator: constraints and costFunction
 */

public class OptimizationMediator implements OptimizationMediatorInterface {

    DesignVariable designVariable;
    CostFunction costFunction;
    List<Constraint> constraints;
    List<Boolean> constraintCheckResults;
    double costResult;
    ChainOfConstraintTypes chain;


    public OptimizationMediator(DesignVariable designVariable, CostFunction costFunction, List<Constraint> constraints) {
        this.designVariable = designVariable;
        this.costFunction = costFunction;
        costFunction.setMediator(this);
        this.constraints = constraints;
        defineConstraints(constraints);
        this.constraintCheckResults = new ArrayList<>();
        chain=new ChainOfConstraintTypes();
        chain.setMediatorInChain(this);
    }

    private void defineConstraints(List<Constraint> constraints) {
        this.constraints =new ArrayList<>();
        for (Constraint constraint: constraints) {
            constraint.setMediator(this);
            this.constraints.add(constraint);
        }
    }

    @Override
    public void run() {
        constraintCheckResults.clear();
        evaluateConstraints();
        setCostResult(costFunction.calculate());
    }

    //the constraint will be "caught" by relevant receiver in chain of responsibility
    private void evaluateConstraints() {
        for (Constraint constraint: constraints) {
            chain.process(constraint);
        }
    }

    @Override
    public void setDesignVariable(DesignVariable designVariable) {
        this.designVariable=designVariable;
    }

    @Override
    public DesignVariable getDesignVariable() {
        return designVariable;
    }

    @Override
    public void addConstraint(Constraint constraint) {
        constraint.setMediator(this);
        constraints.add(constraint);
    }

    @Override
    public void addConstraintCheckResults(boolean checkResult) {
        constraintCheckResults.add(checkResult);
    }


    @Override
    public List<Boolean> getConstraintCheckResults() {
        return constraintCheckResults;
    }

    @Override
    public void setCostResult(double result) {
        costResult=result;
    }

    @Override
    public double getCostResult() {
        return costResult;
    }

    @Override
    public boolean areConstraintsFeasible() {
        List<Boolean> constraints = getConstraintCheckResults();
        boolean anyViolatedConstraint=constraints.stream().anyMatch(c -> !c);
        return !anyViolatedConstraint;
    }


}
