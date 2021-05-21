package com.pluralsight.annotation;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @Inherited
    public @interface HelloAnnotation {
        String value();
    }

    public static class HelloAnnotationClient {
        @HelloAnnotation(value = "Simple custom  Annotation example")
        public void sayHello() {
            System.out.println("Inside sayHello method..");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        HelloAnnotationClient helloAnnotationClient = new HelloAnnotationClient();

        Method method = helloAnnotationClient.getClass().getMethod("sayHello");
        if (method.isAnnotationPresent(HelloAnnotation.class)) {
            HelloAnnotation helloAnnotation = method.getAnnotation(HelloAnnotation.class);

            System.out.println("Value : " + helloAnnotation.value()); //Get value of custom annotation
            method.invoke(helloAnnotationClient); //Invoke sayHello method
        }
    }
}
