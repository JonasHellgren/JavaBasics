package medium.interface_signatures;

public record Product (
        String name,
        int nSoldUnits
) {

    public static Product of(String name, int nSold) {
        return new Product(name,nSold);
    }
}
