package pluralsight_courses.making_code_more_object_oriented.optional.maybe_string;

import org.junit.Test;

public class MainString {

    public static void main(String[] args) {

        display(new NoString());
        display(new SomeString("Something"));

    }

    static void display(MaybeStringInterface maybeString) {
        String textToPrint= maybeString.toUpperCase().orElse("Nothing to show");
        System.out.println("textToPrint = " + textToPrint);
    }

}
