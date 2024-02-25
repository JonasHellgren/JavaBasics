package common;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static double doubleInInterval(double min, double max) {
        return (Math.random() * (max - min)) + min;
    }


    public static List<Double> doublesInInterval(double min, double max, int nofElements) {
        List<Double> randList = new ArrayList<>();
        for (int i = 0; i < nofElements; i++) {
            randList.add(doubleInInterval(min, max));
        }
        return randList;
    }

    public static double randomNumberBetweenZeroAndOne() {
        return  doubleInInterval(0, 1);
    }

    public static int getRandomIntNumber(int minInclusive, int maxExclusive) {
        return (int) ((Math.random() * (maxExclusive - minInclusive)) + minInclusive);
    }

}
