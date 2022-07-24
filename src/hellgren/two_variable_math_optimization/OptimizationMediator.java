package hellgren.two_variable_math_optimization;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Thanks to the mediator pattern fields do not need to be transferred via method parameters.
 * Following fields will have access to the mediator: chain and costFunction.
 * Chain requires access to designVariable and constraintCheckResults.
 * costFunction requires access to designVariable and costResult.
 *
 * The chain field implements the chain of responsibility pattern. A constraint will be "caught" by the relevant
 * receiver in the chain.
 */

public class OptimizationMediator implements OptimizationMediatorInterface {

    DesignVariable designVariable;
    CostFunction costFunction;
    List<ConstraintAbstract> constraints;
    List<Boolean> constraintCheckResults;
    double costResult;
    ChainOfConstraintTypes chain;

    public OptimizationMediator(@NonNull  DesignVariable designVariable,
                                @NonNull CostFunction costFunction,
                                @NonNull List<ConstraintAbstract> constraints) {
        this.designVariable = designVariable;
        this.costFunction = costFunction;
        costFunction.setMediator(this);
        this.constraints = constraints;
        defineConstraints(constraints);
        this.constraintCheckResults = new ArrayList<>();
        chain=new ChainOfConstraintTypes();
        chain.setMediatorInChain(this);
    }

    private void defineConstraints(List<ConstraintAbstract> constraints) {
        this.constraints =new ArrayList<>();
        this.constraints.addAll(constraints);
    }

    @Override
    public void run() {
        constraintCheckResults.clear();
        evaluateConstraints();
        setCostResult(costFunction.calculate());
    }


    private void evaluateConstraints() {
        for (ConstraintAbstract constraint: constraints) {
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
    public void addConstraint(ConstraintAbstract constraint) {
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
