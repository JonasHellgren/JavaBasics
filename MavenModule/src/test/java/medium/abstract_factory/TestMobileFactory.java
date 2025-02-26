package medium.abstract_factory;

import lombok.NonNull;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestMobileFactory {

     @SneakyThrows
     @Test
      void testProduceAndroid() {
         String os = "android";
         Mobile mobile = getMobile(os);
         mobile.photo();
         mobile.video("8k");
         mobile.setDisplay(120);

         Assertions.assertEquals(os,mobile.name);

      }

    private static @NonNull Mobile getMobile(String os) throws InvalidMobile {
        var mobileComponentFactory = switch (os.toLowerCase()){
            case "ios" -> new IPhoneFactory();
            case "android" -> new OnePlusFactory();
            default -> throw new InvalidMobile();
        };

        return new Mobile(mobileComponentFactory);
    }
}
