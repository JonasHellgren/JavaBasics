package effective_java.creating_objects.item1;

import java.util.HashMap;
import java.util.Map;

public class ColorWithoutDuplicates {
    private static final Map< Integer, ColorWithoutDuplicates> CACHE =
            new HashMap< >();

    private ColorWithoutDuplicates(int h) {
    }

    public static int sizeOfCache()  {  //for testing
        return CACHE.size();
    }

    public static ColorWithoutDuplicates makeFromPalette(int red, int green, int blue) {
        final int hex = red << 16 + green << 8 + blue;
        return ColorWithoutDuplicates.CACHE.computeIfAbsent(  //run code in 2nd argument if hex not present in map
                hex, h -> new ColorWithoutDuplicates(h)
        );
    }

}
