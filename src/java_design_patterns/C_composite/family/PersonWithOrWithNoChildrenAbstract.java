package java_design_patterns.C_composite.family;

import lombok.SneakyThrows;

import java.util.List;

public abstract class PersonWithOrWithNoChildrenAbstract implements PersonInterface {

    Integer id;
    String name;
    Counter counter;

    public PersonWithOrWithNoChildrenAbstract(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @SneakyThrows
    @Override
    public void addChildren(PersonWithOrWithNoChildrenAbstract person) {
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

    @Override
    public int nofOffSprings() {
        return 0;
    }


    @SneakyThrows
    protected  List<PersonWithOrWithNoChildrenAbstract> getChildren() {
        throw new NoSuchMethodException();  //ensure defined in sub-classes
    }

    @SneakyThrows
    protected void nofOffSpringsRec(PersonWithOrWithNoChildrenAbstract node, Counter counter) {
       throw new NoSuchMethodException();  //ensure defined in sub-classes
    }

    @SneakyThrows
    @Override
    public void printTree() {
        throw new NoSuchMethodException(); //ensure defined in sub-classes
    }
}
