package hellgren.two_variable_math_optimization;

import java.util.ArrayList;
import java.util.List;

public class OptMediator implements OptMediatorInterface {

    DesignVariable designVariable;
    List<Constraint> constraints;
    List<Boolean> constraintCheckResults;
    Chain chain;


    public OptMediator(DesignVariable designVariable, List<Constraint> constraints) {
        this.designVariable = designVariable;
        this.constraints = constraints;

        this.constraints=new ArrayList<>();
        for (Constraint constraint:constraints) {
            constraint.setMediator(this);
            this.constraints.add(constraint);
        }
        this.constraintCheckResults = new ArrayList<>();

        chain=new Chain();


    }

    @Override
    public void run() {
        for (Constraint constraint:constraints) {
            chain.process(constraint);
        }
    }

    @Override
    public void setDesignVariable() {

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
        System.out.println("addConstraintCheckResults called");
        constraintCheckResults.add(checkResult);
    }


    @Override
    public List<Boolean> getConstraintCheckResults() {
        return constraintCheckResults;
    }
}
