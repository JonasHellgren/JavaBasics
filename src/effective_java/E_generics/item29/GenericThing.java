package effective_java.E_generics.item29;

public class GenericThing<T> {
    private T val;

    public GenericThing(T val) { this.val = val;}
    public T getVal() { return this.val; }

    public <T> void printVal(T val) {
        System.out.println("Generic Type" + val.getClass().getName());
    }
    }
