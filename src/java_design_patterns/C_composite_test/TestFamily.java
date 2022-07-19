package java_design_patterns.C_composite_test;

import java_design_patterns.C_composite.family.NodeAbstract;
import java_design_patterns.C_composite.family.PersonWithChildren;
import java_design_patterns.C_composite.family.PersonWithNoChildren;
import org.junit.Assert;
import org.junit.Test;

public class TestFamily {

    @Test
    public void testOnePerson() {
        NodeAbstract node=new PersonWithNoChildren(1,"Rune");
        node.printName();
        Assert.assertEquals(0,node.nofChildren());
    }

    @Test
    public void testFatherThreeChildren() {
        NodeAbstract parent=new PersonWithChildren(1,"Maria");

        NodeAbstract child1=new PersonWithNoChildren(2,"Johannes");
        NodeAbstract child2=new PersonWithNoChildren(3,"Hannah");
        NodeAbstract child3=new PersonWithNoChildren(4,"Alexander");

        parent.addChildren(child1);
        parent.addChildren(child2);
        parent.addChildren(child3);

        parent.printName();

        Assert.assertEquals(3,parent.nofChildren());
        Assert.assertEquals(0,child1.nofChildren());
    }

    @Test
    public void testGrandFather() {
        NodeAbstract grandFather=new PersonWithChildren(1,"Rune");

        NodeAbstract mother=new PersonWithChildren(2,"Maria");
        grandFather.addChildren(mother);

        NodeAbstract childMother1=new PersonWithNoChildren(3,"Johannes");
        NodeAbstract childMother2=new PersonWithNoChildren(4,"Hannah");
        NodeAbstract childMother3=new PersonWithNoChildren(5,"Alexander");

        mother.addChildren(childMother1);
        mother.addChildren(childMother2);
        mother.addChildren(childMother3);

        grandFather.printName();

        Assert.assertEquals(0,childMother1.nofChildren());

        System.out.println("grandFather.nofOffSprings() = " + grandFather.nofOffSprings());
    }

}
