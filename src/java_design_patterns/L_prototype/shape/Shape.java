package java_design_patterns.L_prototype.shape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class Shape implements Cloneable {

    private String id;
    protected String type;

    abstract void draw();

    public Shape clone() {
        Shape clone = null;

        try {
            clone = (Shape) super.clone();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public boolean equals(Shape other) {

        if (!this.getClass().equals(other.getClass()))
            return false;

        if (!this.id.equals(other.id) || !this.type.equals(other.type))
            return false;

        return true;




    }

}