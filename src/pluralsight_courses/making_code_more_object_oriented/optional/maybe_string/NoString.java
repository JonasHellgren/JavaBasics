package pluralsight_courses.making_code_more_object_oriented.optional.maybe_string;

public class NoString implements MaybeStringInterface {

    public NoString() {
    }

    @Override
    public MaybeStringInterface toUpperCase() {
        return this;
    }

    @Override
    public String orElse(String substite) {
        return substite;
    }
}
