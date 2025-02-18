package medium.abstract_factory;

// InvalidMobile
public class InvalidMobile extends Exception {
    @Override
    public String getMessage() {
        return "Mobile doesn't exist";
    }
}