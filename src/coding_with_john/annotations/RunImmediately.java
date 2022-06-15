package coding_with_john.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)  //for ex SOURCE means only relevant before compilation
public @interface RunImmediately {
    int times() default 0 ;  //default optional
}

