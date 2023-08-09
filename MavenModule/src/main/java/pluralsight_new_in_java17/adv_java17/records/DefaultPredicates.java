package pluralsight_new_in_java17.adv_java17.records;

import java.util.Objects;
import java.util.function.BiFunction;

public class DefaultPredicates {

    public static BiFunction<String,String,String > defaultIfNullString=(v, d) -> Objects.isNull(v)?d:v;
    public static BiFunction<Integer,Integer,Integer> defaultIfNullInteger=(v, d) -> Objects.isNull(v)?d:v;
}
