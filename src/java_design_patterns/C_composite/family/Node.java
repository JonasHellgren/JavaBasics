package java_design_patterns.C_composite.family;

public interface Node {

    void addChildren(NodeAbstract node);
    Integer getIndex();
    String getName();
    public int nofChildren();
    void printName();

}
