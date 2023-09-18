package java_design_patterns.flyweight_pattern;

import java.util.HashMap;

public class GxfObjectFactory {

    private static final HashMap<String, Circle> circleMap = new HashMap<>();

    public  Circle getCharacter(String color) {
        Circle character =  circleMap.get(color);
        if (character == null) {
            character = new Circle(color);
            circleMap.put(color, character);
        }
        return character;
    }


    public int getMapSize()   {
        return circleMap.size();
    }

}
