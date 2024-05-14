package medium.interface_signatures;

public record Company (
        String name
) {

    public static Company of(String name) {
        return new Company(name);
    }
}
