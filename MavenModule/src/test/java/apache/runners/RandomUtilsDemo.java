package apache.runners;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtilsDemo {
    public static void main(String[] args) {
        // Generate a random int between 5 (inclusive) and 10 (exclusive)
        int randomInt = RandomUtils.nextInt(5, 10);
        System.out.println("Random Int: " + randomInt);

        // Generate a random double within the range [0.0, 1.0)
        double randomDouble = RandomUtils.nextDouble(0.0, 1.0);
        System.out.println("Random Double: " + randomDouble);

        boolean randBool=RandomUtils.nextBoolean();
        System.out.println("randBool = " + randBool);


    }
}