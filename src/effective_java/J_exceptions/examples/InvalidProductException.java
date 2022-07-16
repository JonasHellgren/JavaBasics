package effective_java.J_exceptions.examples;

public class InvalidProductException extends Exception
{

    Integer weight;
    public InvalidProductException(String s, Integer weight)
    {
        // Call constructor of parent Exception
        super(s);
        this.weight=weight;
    }

    public Integer getWeight() {
        return weight;
    }
}
