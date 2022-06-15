package coding_with_john.annotations;

import lombok.SneakyThrows;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestAnnotations {

    @Test
    public void testCatImportant() {
        Cat cat = new Cat();
        Assert.assertTrue(cat.getClass().isAnnotationPresent(VeryImportant.class));
    }

    @Test
    public void testDogNotImportant() {
        Dog dog = new Dog();
        Assert.assertFalse(dog.getClass().isAnnotationPresent(VeryImportant.class));
    }

    @Test
    public void testRunImmediatelyCat() {
        Cat cat = new Cat();
        int annotMethodsCount = 0;
        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                annotMethodsCount++;
            }
        }
        Assert.assertEquals(1, annotMethodsCount);
    }

    @SneakyThrows
    @Test
    public void testRunImmediatelyDog() {
        Dog dog = new Dog();
        int invokeCount = 0;
        for (Method method : dog.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately annotation = method.getAnnotation(RunImmediately.class);
                for (int i = 0; i < annotation.times(); i++) {
                    method.invoke(dog);
                    invokeCount++;
                }
            }
        }
        Assert.assertEquals(3, invokeCount);
    }

    @SneakyThrows
    @Test
    public void testImportantFieldCat() {
        Cat cat = new Cat();
        int annotFieldsCount = 0;
        String nameUpperCase = "";
        for (Field field : cat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantField.class)) {
                annotFieldsCount++;
                Object value = field.get(cat);
                if (value instanceof String) {
                    nameUpperCase = ((String) value).toUpperCase();
                }
            }
        }

        System.out.println("annotFieldsCount = " + annotFieldsCount);
        System.out.println("nameUpperCase = " + nameUpperCase);

        Assert.assertEquals(1, annotFieldsCount);
        Assert.assertEquals("DONNA", nameUpperCase);
    }
}
