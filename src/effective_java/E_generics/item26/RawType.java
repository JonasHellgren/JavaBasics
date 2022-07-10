package effective_java.E_generics.item26;

public class RawType<T> {
    T t;
    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}