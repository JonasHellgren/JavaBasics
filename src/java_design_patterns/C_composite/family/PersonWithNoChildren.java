package java_design_patterns.C_composite.family;

public class PersonWithNoChildren extends NodeAbstract {

    public PersonWithNoChildren(Integer id, String name) {
        super(id,name);
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
    public void printName() {
        System.out.println("*"+super.getName());
    }
}
