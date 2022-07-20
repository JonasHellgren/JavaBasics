package java_design_patterns.C_composite.family;

import java.util.ArrayList;
import java.util.List;

public class PersonWithChildren extends PersonWithOrWithNoChildrenAbstract {

    List<PersonWithOrWithNoChildrenAbstract> children;

    public PersonWithChildren(Integer id, String name) {
        super(id,name);
        children=new ArrayList<>();
    }

    @Override
    public void addChildren(PersonWithOrWithNoChildrenAbstract node) {
        children.add(node);
    }

    @Override
    public Integer getIndex() {
        return super.id;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    protected   List<PersonWithOrWithNoChildrenAbstract> getChildren() {
        return children;
    }

    @Override
    public int nofChildren() {
        return children.size();
    }

    @Override
    public void printTree() {
        System.out.println(super.getName());
        children.forEach(PersonWithOrWithNoChildrenAbstract::printTree);
    }

    @Override
    public int nofOffSprings() {
        counter = new Counter();
        nofOffSpringsRec(this,counter);
        return counter.value();
    }


    protected void nofOffSpringsRec(PersonWithOrWithNoChildrenAbstract node, Counter counter) {
        for (PersonWithOrWithNoChildrenAbstract child:node.getChildren()) {
            System.out.println("child.name = " + child.name);
            counter.increment();
            child.nofOffSpringsRec(child,counter);
        }

    }


}
