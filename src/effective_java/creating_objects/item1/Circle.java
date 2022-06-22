package effective_java.creating_objects.item1;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Circle implements Shape {
    int radius;
}
