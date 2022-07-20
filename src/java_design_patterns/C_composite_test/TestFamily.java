package java_design_patterns.C_composite_test;

import java_design_patterns.C_composite.family.PersonInterface;
import java_design_patterns.C_composite.family.PersonWithOrWithNoChildrenAbstract;
import java_design_patterns.C_composite.family.PersonWithChildren;
import java_design_patterns.C_composite.family.PersonWithNoChildren;
import org.junit.Assert;
import org.junit.Test;

public class TestFamily {

    @Test
    public void testOnePerson() {
        PersonInterface node=new PersonWithNoChildren(1,"Rune");
        node.printTree();
        Assert.assertEquals(0,node.nofChildren());
    }

    @Test
    public void testFatherThreeChildren() {
        PersonInterface  parent=new PersonWithChildren(1,"Maria");

        PersonInterface child1=new PersonWithNoChildren(2,"Johannes");
        PersonInterface child2=new PersonWithNoChildren(3,"Hannah");
        PersonInterface child3=new PersonWithNoChildren(4,"Alexander");

        parent.addChildren(child1);
        parent.addChildren(child2);
        parent.addChildren(child3);

        parent.printTree();

        Assert.assertEquals(3,parent.nofChildren());
        Assert.assertEquals(0,child1.nofChildren());

    }

    @Test
    public void testGrandFather() {
        PersonInterface grandFather=new PersonWithChildren(1,"Rune");

        PersonInterface mother=new PersonWithChildren(2,"Maria");
        grandFather.addChildren(mother);

        PersonInterface childMother1=new PersonWithNoChildren(3,"Johannes");
        PersonInterface childMother2=new PersonWithNoChildren(4,"Hannah");
        PersonInterface childMother3=new PersonWithNoChildren(5,"Alexander");

        mother.addChildren(childMother1);
        mother.addChildren(childMother2);
        mother.addChildren(childMother3);

        grandFather.printTree();
        System.out.println("grandFather.nofOffSprings() = " + grandFather.nofOffSprings());

        Assert.assertEquals(0,childMother1.nofChildren());
        Assert.assertEquals(4,grandFather.nofOffSprings());
    }

}
