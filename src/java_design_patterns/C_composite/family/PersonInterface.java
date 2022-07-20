package java_design_patterns.C_composite.family;

import lombok.SneakyThrows;

import java.util.List;

public interface PersonInterface {
    void addChildren(PersonInterface node);
    List<PersonInterface> getChildren();
    Integer getIndex();
    String getName();
    int nofChildren();
    int nofOffSprings();
    void printTree();
}
