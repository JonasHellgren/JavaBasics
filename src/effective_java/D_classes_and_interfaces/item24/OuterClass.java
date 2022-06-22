package effective_java.D_classes_and_interfaces.item24;

//A static inner class does not need any outer class reference to access the member variables.
public class OuterClass {

    static int i = 1;
    int j = 9;

    public static void setI(int i) {
        OuterClass.i = i;
    }

    public static class InnerClass {
        public static void printNum() {
            System.out.println(i);
        }

        public static int getNum() {
            return i;
        }

    }



}
