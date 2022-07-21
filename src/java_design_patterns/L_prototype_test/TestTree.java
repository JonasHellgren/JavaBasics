package java_design_patterns.L_prototype_test;

import java_design_patterns.L_prototype.tree.PlasticTree;
import java_design_patterns.L_prototype.tree.Tree;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestTree {

    public static final double MASS = 10;
    public static final double HEIGHT=2;
    public static final double POSITION=12124;
    public static final double OTHER_POSITION=1235241;

    @Test
    public void givenAPlasticTreePrototypeWhenClonedThenCreateA_Clone() {
        // ...

        Tree plasticTree = new PlasticTree(MASS, HEIGHT);
        plasticTree.setPosition(POSITION);
        PlasticTree anotherPlasticTree = (PlasticTree) plasticTree.copy();
        anotherPlasticTree.setPosition(OTHER_POSITION);

        Assert.assertEquals(POSITION, plasticTree.getPosition(),1);
        Assert.assertEquals(OTHER_POSITION, anotherPlasticTree.getPosition(),1);
    }

    @Test
    public void givenA_ListOfTreesWhenClonedThenCreateListOfClones() {

        Tree plasticTree = new PlasticTree(MASS, HEIGHT);
        plasticTree.setPosition(POSITION);

        Tree pineTree = new PlasticTree(2*MASS, 2*HEIGHT);
        pineTree.setPosition(POSITION);

        List<Tree> trees = Arrays.asList(plasticTree, pineTree);
        List<Tree> treeClones = trees.stream().map(Tree::copy).collect(Collectors.toList());

        treeClones.forEach(System.out::println);
        Assert.assertEquals(2, treeClones.size());


    }


}
