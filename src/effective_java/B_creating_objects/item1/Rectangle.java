package effective_java.B_creating_objects.item1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Rectangle implements Shape {
    int width;
    int height;
}
