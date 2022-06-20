package effective_java.creating_objects;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Circle implements Shape {
    int radius;
}
