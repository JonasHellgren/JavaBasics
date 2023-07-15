package hellgren.debugging;

import org.junit.jupiter.api.MethodOrderer;

import java.util.Random;

/***
 * ArithmeticException if d is zero
 * Hence breakpoint with condition
 */

public class ForLoopForDebug {

    public static final int MAX_RAND = 1000;
    public static final int MIN_RAND = 0;
    public static final int MAX_I = MAX_RAND;

    public static void main(String[] args) {

        Random random=new Random();
        int numerator=0;
        for (int i = 0; i < MAX_I; i++) {
            int randInt=  random.nextInt(MAX_RAND - MIN_RAND) + MIN_RAND;
            numerator=i-randInt % 10;
            int d = getD(numerator);
            System.out.println("d = " + d);
        }

    }

    private static int getD(int numerator) {
        return 10/ numerator;
    }


}
