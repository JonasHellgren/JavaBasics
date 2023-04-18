package pluralsight_courses.making_code_more_object_oriented.optional.maybe_string;

public class SomeString implements MaybeStringInterface {
    private final String string;

    public SomeString(String string) {
        this.string = string;
    }

    @Override
    public MaybeStringInterface toUpperCase() {
        return new SomeString(this.string.toUpperCase());
    }

    @Override
    public String orElse(String substite) {
        return this.string;
    }
}
