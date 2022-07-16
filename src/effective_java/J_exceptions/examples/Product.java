package effective_java.J_exceptions.examples;

public class Product {

    public static final int MAX_WEIGHT = 100;

    public void productCheck(int weight) throws InvalidProductException{
        if(weight> MAX_WEIGHT){
            throw new InvalidProductException("Product Invalid", weight);
        }
}
}

