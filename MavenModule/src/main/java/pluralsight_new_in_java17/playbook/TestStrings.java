package pluralsight_new_in_java17.playbook;

import org.junit.Test;
import java.util.StringJoiner;
import java.util.function.Function;
import static org.junit.Assert.*;

/***
 * isEmpty requires no characters, isBlank gives true also for ex space
 
 */

public class TestStrings {

    String EMPTY="";
    String WITH_SPACE =" ";

    @Test
    public void givenEmpty_thenIsEmptyTrue() {
        assertTrue(EMPTY.isEmpty());
    }

    @Test
    public void givenWithSpace_thenIsEmptyFalse() {
        assertFalse(WITH_SPACE.isEmpty());
    }

    @Test
    public void givenEmpty_thenIsBlankTrue() {
        assertTrue(EMPTY.isBlank());
    }

    @Test
    public void givenWithSpace_thenIsBlankTrue() {
        assertTrue(WITH_SPACE.isBlank());
    }

    @Test
    public void givenMoneyString_whenTransform_thenOnlyNumbers() {
        String money=" 100 Euro ";
        String onlyNum = cleanString(money);
        assertEquals("100",onlyNum);
    }

    @Test
    public void testStringJoiner() {
        StringJoiner stringJoiner=new StringJoiner(",","{","}");
        stringJoiner.add("1");
        stringJoiner.add("2");
        String text=stringJoiner.toString();
        assertEquals("{1,2}",text);
    }


    @Test
    public void testTextBlock() {
        String text= """
                I am
                a text block
                """;
        System.out.println("text = " + text);
        assertEquals(2,text.lines().count());
    }

    private String cleanString(String string) {
        Function<String, String> smallCharReplacer = s -> s.replaceAll("[a-z]", "");
        Function<String, String> bigCharReplacer = s -> s.replaceAll("[A-Z]", "");
        Function<String, String> spaceRemover = s -> s.trim();

        return string
                .transform(smallCharReplacer)
                .transform(bigCharReplacer)
                .transform(spaceRemover);
    }


}
