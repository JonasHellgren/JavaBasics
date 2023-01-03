package effective_java.E_generics.item29;


//limited to Number and its subtypes
public class GenericThingExtendsNumber<T extends Number> {
    private T val;

    public GenericThingExtendsNumber(T val) { this.val = val;}
    public T getVal() { return this.val;
    }

}