package hellgren.two_variable_math_optimization;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOptimizationProblem {

    List<Constraint> constraintsEmpty= new ArrayList<>();

    @Test
    public void test1and2GivesCostOf3() {
        DesignVariable x=new DesignVariable(1,2);
        CostFunction costFunction=new CostFunction(1,1,0);

        OptimizationMediator mediator=new OptimizationMediator(x,costFunction,constraintsEmpty);
        mediator.run();

        Assert.assertEquals(3,mediator.getCostResult(),0.1);
    }

    @Test
    public void test0and0GivesCostOfC() {
        DesignVariable x=new DesignVariable(0,0);
        double c=10;
        CostFunction costFunction=new CostFunction(0,0,c);

        OptimizationMediator mediator=new OptimizationMediator(x,costFunction,constraintsEmpty);
        mediator.run();

        Assert.assertEquals(c,mediator.getCostResult(),0.1);
    }

    @Test
    public void testFindBestDesignVariableShallBeCloseTo2and2() {
        DesignVariable x0=new DesignVariable(0,0);
        CostFunction costFunction=new CostFunction(1,1,0);
        Constraint constrainBound=new ConstraintBound(2,2);
        List<Constraint> constraints= new ArrayList<>();
        constraints.add(constrainBound);

        OptimizationMediator mediator=new OptimizationMediator(x0,costFunction,constraints);
        mediator.run();
        System.out.println(mediator.getConstraintCheckResults());

        DesignVariable xBest=findXbest(mediator);

        Assert.assertEquals(2,xBest.x1,0.1);
        Assert.assertEquals(2,xBest.x2,0.1);
    }

    private DesignVariable findXbest(OptimizationMediator mediator) {
        DesignVariable xBest=new DesignVariable(0,0);
        double costBest=-Double.MAX_VALUE;
        for (int i = 0; i < 1000 ; i++) {

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
        Random r = new Random();
        double rangeMin=0, rangeMax=2;
        double x1=  getRandomNumber(r, rangeMin, rangeMax);
        double x2=  getRandomNumber(r, rangeMin, rangeMax);
        DesignVariable xTest=new DesignVariable(x1,x2);
        return xTest;
    }

    private double getRandomNumber(Random r, double rangeMin, double rangeMax) {
        return  rangeMin + (rangeMax - rangeMin) * r.nextDouble();
    }

}
