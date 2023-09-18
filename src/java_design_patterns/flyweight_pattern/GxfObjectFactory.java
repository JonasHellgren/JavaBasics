package java_design_patterns.flyweight_pattern;

import java.util.HashMap;

public class GxfObjectFactory {

    private static final HashMap<String, Circle> circleMap = new HashMap<>();

    public Circle getGfxObject(String color) {
        Circle character;
        if (isNotColorInMap(color)) {
            character = new Circle(color);
            circleMap.put(color, new Circle(color));
        } else {
            character = circleMap.get(color);
        }
        return character;
    }

    private static boolean isNotColorInMap(String color) {
        return !circleMap.containsKey(color);
    }


    public int getMapSize() {
        return circleMap.size();
    }

}
