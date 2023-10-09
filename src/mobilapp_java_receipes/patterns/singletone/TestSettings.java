package mobilapp_java_receipes.patterns.singletone;

import org.junit.Assert;
import org.junit.Test;

public class TestSettings {


    @Test
    public void test() {
        var settings = Settings.getInstance();
        //Settings settings = new Settings(); //<- Error

        settings.host = "192.168.100.1";
        settings.port = 33;

        var settings1 = Settings.getInstance();

        System.out.println("settings = " + settings);

        Assert.assertEquals(settings, settings1);  //same address/instance

    }


}
