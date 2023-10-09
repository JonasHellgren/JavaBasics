package mobilapp_java_receipes.patterns_regex;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class TestPatterns {

    @Test
    public void test() {
        var data = "Pi = 3.14, exponent = 2.718";
        var pattern = "\\d+\\.\\d+";
        var p = Pattern.compile(pattern);
        var m = p.matcher(data);
        var matches = new ArrayList<String>();
        while (m.find()) {
            matches.add(m.group(0));
        }
        System.out.println("matches = " + matches);
        Assert.assertTrue(matches.contains("3.14"));

    }
}
