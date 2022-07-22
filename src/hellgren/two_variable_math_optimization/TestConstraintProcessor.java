package hellgren.two_variable_math_optimization;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestConstraintProcessor {

    @Test
    public void test1and2SmEq2and2() {
        DesignVariable x=new DesignVariable(1,2);
        Constraint constrainBound=new ConstraintBound(2,2);
        List<Constraint> constraints= new ArrayList<>();
        constraints.add(constrainBound);

        OptMediator mediator=new OptMediator(x,constraints);
        mediator.run();
        System.out.println(mediator.getConstraintCheckResults());

        Assert.assertTrue(mediator.getConstraintCheckResults().get(0));

    }

    @Test
    public void test1and2SmEq2and2AndSumOk() {
        DesignVariable x=new DesignVariable(1,2);
        Constraint constrainBound=new ConstraintBound(2,2);
        Constraint constraintSum=new ConstraintSum(20);
        List<Constraint> constraints= new ArrayList<>();
        constraints.add(constrainBound);
        constraints.add(constraintSum);

        OptMediator mediator=new OptMediator(x,constraints);
        mediator.run();
        System.out.println(mediator.getConstraintCheckResults());

        Assert.assertTrue(mediator.getConstraintCheckResults().get(0));
        Assert.assertTrue(mediator.getConstraintCheckResults().get(1));

    }
}
