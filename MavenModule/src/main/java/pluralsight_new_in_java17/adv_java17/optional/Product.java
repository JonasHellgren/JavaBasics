package pluralsight_new_in_java17.adv_java17.optional;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.bytedeco.opencv.presets.opencv_core;

import java.util.List;

@AllArgsConstructor
@Getter
@ToString
public class Product {
    public static final String NEW_NAME = "Donald";
    public Long id;
    public String name;

    public void changeNameDoDonald() {
        name= NEW_NAME;
    }
}
