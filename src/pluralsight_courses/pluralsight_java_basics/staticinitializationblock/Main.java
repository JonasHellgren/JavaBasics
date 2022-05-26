package pluralsight_courses.pluralsight_java_basics.staticinitializationblock;

public class Main {
    public static void main(String[] args) {
        int  intnra, intnrb ;
        //Although we don't have an object of IntListManager, it static block is called
        //inlist is showed when created
        intnra = IntListManager.FindInt(1);    System.out.println(intnra);
        intnrb = IntListManager.FindInt(8);   System.out.println(intnrb);

        //inlist is kept, so showed again
        IntListManager im= new IntListManager();     im.ShowIntlist();
    }
}
