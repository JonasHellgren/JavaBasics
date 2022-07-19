package java_design_patterns.C_composite.family;

import java.util.ArrayList;
import java.util.List;

public class PersonWithChildren extends NodeAbstract {

    List<NodeAbstract> children;


    public PersonWithChildren(Integer id, String name) {
        super(id,name);
        children=new ArrayList<>();
    }

    @Override
    public void addChildren(NodeAbstract node) {
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
    public  List<NodeAbstract> getChildren() {
        return children;
    }

    @Override
    public int nofChildren() {
        return children.size();
    }

    @Override
    public void printName() {
        System.out.println(super.getName());
        children.forEach(NodeAbstract::printName);
    }

    public Integer nofOffSprings() {
        nofOffSprings = 0;
        nofOffSpringsRec(this,this);
        return nofOffSprings;
    }

    @Override
    public void nofOffSpringsRec(NodeAbstract node,NodeAbstract nodeParent) {
        for (NodeAbstract child:node.getChildren()) {
            System.out.println("child.name = " + child.name);
            nodeParent.nofOffSprings++;
            child.nofOffSpringsRec(child,nodeParent);
        }

    }


}
