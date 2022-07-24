package hellgren.two_variable_math_optimization.facade;

import hellgren.two_variable_math_optimization.mediator.OptimizationMediator;
import hellgren.two_variable_math_optimization.constraints.ConstraintAbstract;
import hellgren.two_variable_math_optimization.cost_designvariable.CostFunction;
import hellgren.two_variable_math_optimization.cost_designvariable.DesignVariable;
import lombok.NonNull;

import java.util.List;
import java.util.Random;

/**
 * Facade pattern is used to hide implementation details of mediator
 */

public class TwoVariableOptimizer implements TwoVariableOptimizerInterface {

    public static final int NOF_ITERATIONS = 10000;

    CostFunction costFunction;
    List<ConstraintAbstract> constraints;
    Random r;

    public TwoVariableOptimizer(@NonNull  CostFunction costFunction,
                                @NonNull List<ConstraintAbstract> constraints) {
        this.costFunction = costFunction;
        this.constraints = constraints;
        r = new Random();
    }

    @Override
    public DesignVariable findOptimal() {
        DesignVariable x0=new DesignVariable(0,0);

        OptimizationMediator mediator=new OptimizationMediator(x0,costFunction,constraints);
        mediator.run();
        return findXbest(mediator);
    }

    private DesignVariable findXbest(OptimizationMediator mediator) {
        DesignVariable xBest=new DesignVariable(0,0);
        double costBest=-Double.MAX_VALUE;
        for (int i = 0; i < NOF_ITERATIONS; i++) {

            DesignVariable xTest = getRandomDesignVariable();
            mediator.setDesignVariable(xTest);
            mediator.run();

            double costResult= mediator.getCostResult();
            if (mediator.areConstraintsFeasible() && costResult>costBest) {
                costBest=costResult;
                xBest.copy(xTest);
                System.out.println("New better xBest = "+ xBest);
            }
        }
        return xBest;
    }

    private DesignVariable getRandomDesignVariable() {
        double rangeMin=0, rangeMax=2;
        double x1=  getRandomNumber(r, rangeMin, rangeMax);
        double x2=  getRandomNumber(r, rangeMin, rangeMax);
        return new DesignVariable(x1,x2);
    }

    private double getRandomNumber(Random r, double rangeMin, double rangeMax) {
        return  rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

}
