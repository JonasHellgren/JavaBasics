package java_design_patterns.H_proxy;

public class ExpensiveObjectProxy implements ExpensiveObjectInterface {
    private static ExpensiveObject object;

    @Override
    public void process() {
        if (object == null) {
            object = new ExpensiveObject();
        }
        object.process();
    }

}
