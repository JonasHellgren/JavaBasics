package java_design_patterns.C_composite.family;

import lombok.Getter;

/***
 * This abstract class mainly adds fields to the PersonInterface
 */

@Getter
public abstract class PersonWithOrWithNoChildrenAbstract implements PersonInterface {

    Integer id;
    String name;
    Counter counter;

    public PersonWithOrWithNoChildrenAbstract(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    //protected => in abstract class
    protected abstract void nofOffSpringsRec(PersonInterface node, Counter counter);


}
