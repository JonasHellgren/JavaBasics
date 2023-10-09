package mobilapp_java_receipes.patterns.template;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class XYClonable implements Cloneable {
    int x,y;


    @Override
    public XYClonable clone() throws CloneNotSupportedException {
            return (XYClonable) super.clone();
    }
}
