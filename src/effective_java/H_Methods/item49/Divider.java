package effective_java.H_Methods.item49;

public class Divider {

    public static Double div(Integer a, Integer b) {
        checkParameters(a, b);
        return (double) a/b;
    }

    private static void checkParameters(Integer a, Integer b) {
        assert a !=null;
        assert b !=null;
        assert b !=0;
    }

}
