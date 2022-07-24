package hellgren.two_variable_math_optimization;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestOptimizationProblem {

    List<ConstraintAbstract> constraintsEmpty= new ArrayList<>();

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
    public void testFindBestDesignVariableShallBeCloseTo2a2() {
        CostFunction costFunction=new CostFunction(1,1,0);
        ConstraintAbstract constrainBound=new ConstraintBound(2,2);
        List<ConstraintAbstract> constraints= new ArrayList<>();
        constraints.add(constrainBound);

        TwoVariableOptimizerInterface optimizer=new TwoVariableOptimizer(costFunction,constraints);
        DesignVariable xBest = optimizer.findOptimal();

        Assert.assertEquals(2,xBest.x1,0.1);
        Assert.assertEquals(2,xBest.x2,0.1);
    }


}
