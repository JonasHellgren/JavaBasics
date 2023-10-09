package mobilapp_java_receipes.patterns.template;


import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class XYZClonable implements Cloneable {
    XYClonable xy;
    int z;

    @Override
    public XYZClonable clone() throws CloneNotSupportedException {
        XYZClonable clone = (XYZClonable) super.clone();
        clone.xy=xy.clone();
        return clone;
    }

}
