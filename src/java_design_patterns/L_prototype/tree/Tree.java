package java_design_patterns.L_prototype.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Tree {
    double mass;
    double height;
    double position;

    public Tree(double mass, double height) {
        this.mass = mass;
        this.height = height;
    }

    public abstract Tree copy();

    @Override
    public String toString() {
        return this.getClass().toString()+" mass = "+mass+" height = "+height;
    }

}


