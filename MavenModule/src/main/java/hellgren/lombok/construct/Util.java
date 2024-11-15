package hellgren.lombok.construct;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Util {

    public static int add(int a, int b) {
        return a + b;
    }

}
