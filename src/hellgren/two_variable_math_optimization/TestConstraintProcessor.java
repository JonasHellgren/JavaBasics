package hellgren.two_variable_math_optimization;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestConstraintProcessor {

    @Test
    public void test1and2SmEq2and2() {
        DesignVariable x=new DesignVariable(1,2);
        ConstraintAbstract constrainBound=new ConstraintBound(2,2);
        List<ConstraintAbstract> constraints= new ArrayList<>();
        constraints.add(constrainBound);

        OptimizationMediator mediator=new OptimizationMediator(x,CostFunction.newEmptyCostFunction(),constraints);
        mediator.run();
        System.out.println(mediator.getConstraintCheckResults());

        Assert.assertTrue(mediator.getConstraintCheckResults().get(0));
        Assert.assertTrue(mediator.areConstraintsFeasible());
    }

    @Test
    public void test1and2SmEq2and2AndSumOk() {
        DesignVariable x=new DesignVariable(1,2);
        ConstraintAbstract constrainBound=new ConstraintBound(2,2);
        ConstraintAbstract constraintSum=new ConstraintSum(20);
        List<ConstraintAbstract> constraints= new ArrayList<>();
        constraints.add(constrainBound);
        constraints.add(constraintSum);

        OptimizationMediator mediator=new OptimizationMediator(x,CostFunction.newEmptyCostFunction(),constraints);
        mediator.run();

        Assert.assertEquals(Arrays.asList(true,true),mediator.getConstraintCheckResults());
        Assert.assertTrue(mediator.areConstraintsFeasible());

    }

    @Test
    public void test1and2SmEq2and2AndSumNotOk() {
        DesignVariable x=new DesignVariable(1,2);
        ConstraintAbstract constrainBound=new ConstraintBound(2,2);
        ConstraintAbstract constraintSum=new ConstraintSum(1);
        List<ConstraintAbstract> constraints= new ArrayList<>();
        constraints.add(constrainBound);
        constraints.add(constraintSum);

        OptimizationMediator mediator=new OptimizationMediator(x,CostFunction.newEmptyCostFunction(),constraints);
        mediator.run();

        Assert.assertEquals(Arrays.asList(true,false),mediator.getConstraintCheckResults());
        Assert.assertFalse(mediator.areConstraintsFeasible());
    }
}
