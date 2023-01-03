package java_design_patterns.C_composite.family;

import java.util.ArrayList;
import java.util.List;

public class PersonWithChildren extends PersonWithOrWithNoChildrenAbstract {

    List<PersonInterface> children;

    public PersonWithChildren(Integer id, String name) {
        super(id,name);
        children=new ArrayList<>();
    }

    @Override
    public void addChildren(PersonInterface node) {
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
    public List<PersonInterface> getChildren() {
        return children;
    }

    @Override
    public int nofChildren() {
        return children.size();
    }

    @Override
    public void printTree() {
        System.out.println("+"+super.getName());
        children.forEach(PersonInterface::printTree);
    }

    @Override
    public int nofOffSprings() {
        counter = new Counter();
        nofOffSpringsRec(this,counter);
        return counter.value();
    }

    @Override
    protected void nofOffSpringsRec(PersonInterface node, Counter counter) {
        for (PersonInterface  child:node.getChildren()) {
            counter.increment();
            nofOffSpringsRec(child,counter);
        }
    }


}
