package java_design_patterns.C_composite.family;

import lombok.SneakyThrows;

import java.util.Collections;
import java.util.List;

public class PersonWithNoChildren extends PersonWithOrWithNoChildrenAbstract {

    public PersonWithNoChildren(Integer id, String name) {
        super(id,name);
    }

    @SneakyThrows
    @Override
    public void addChildren(PersonWithOrWithNoChildrenAbstract person) {
        throw new NoSuchMethodException("Can't add child to person without child");
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
    public void printTree() {
        System.out.println("*"+super.getName());
    }

    protected List<PersonWithOrWithNoChildrenAbstract> getChildren() {
        return Collections.emptyList();
    }

    protected void nofOffSpringsRec(PersonWithOrWithNoChildrenAbstract node, Counter counter) {
    }

}
