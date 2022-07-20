package java_design_patterns.C_composite.family;

public interface PersonInterface {
    void addChildren(PersonWithOrWithNoChildrenAbstract node);
    Integer getIndex();
    String getName();
    int nofChildren();
    int nofOffSprings();
    void printTree();

}
