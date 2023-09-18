package java_design_patterns.flyweight_pattern;

import java.util.HashMap;

public class GxfObjectFactory {

    private static final HashMap<String, GfxObject> circleMap = new HashMap<>();

    public GfxObject getGfxObject(String color) {

        boolean isNotObjectInMap = isNotObjectInMap(color);

        GfxObject character = isNotObjectInMap
                ? new Circle(color)
                : circleMap.get(color);

        circleMap.putIfAbsent(color,character);

        return character;
    }

    private static boolean isNotObjectInMap(String color) {
        return !circleMap.containsKey(color);
    }

    public int getMapSize() {
        return circleMap.size();
    }

}
