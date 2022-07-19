package java_design_patterns.C_composite.family;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;

public class NodeAbstract implements Node {

    Integer id;
    String name;
    Integer nofOffSprings = 0;

    public NodeAbstract(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void addChildren(NodeAbstract node) {
        throw new NoSuchMethodException();
    }

    @Override
    public Integer getIndex() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int nofChildren() {
        return 0;
    }

    public  List<NodeAbstract> getChildren() {
        return Collections.emptyList();
    }

    public void nofOffSpringsRec(NodeAbstract node,NodeAbstract nodeParent) {
    }

    public Integer nofOffSprings() {
        return 0;
    }

    @Override
    public void printName() {
        System.out.println("name = " + name);
    }
}
