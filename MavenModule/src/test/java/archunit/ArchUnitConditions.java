package archunit;


import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import lombok.NonNull;
import lombok.SneakyThrows;
import java.io.BufferedReader;
import java.io.FileReader;

public class ArchUnitConditions {

    private ArchUnitConditions() {
    }

    public static DescribedPredicate<JavaClass> areUtilClasses =
            new DescribedPredicate<>("are utility classes") {
                @Override
                public boolean test(final JavaClass input) {
                    return input.getSimpleName().endsWith("Util");
                }
            };

    public static  ArchCondition<JavaClass> haveNumberOfFieldsLessThanOrEqualTo(int maxFields) {
        return new ArchCondition<>("have no more than " + maxFields + " fields") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                int fieldCount = javaClass.getFields().size();
                if (fieldCount > maxFields) {
                    String message = String.format(
                            "Class %s has %d fields, which exceeds the maximum of %d",
                            javaClass.getName(), fieldCount, maxFields
                    );
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    public static @NonNull ArchCondition<JavaClass> maxNofParameterCondition(int maxParameters) {
        return new ArchCondition<>("have a constructor with maximum " + maxParameters + " parameters") {
            @Override
            public void check(JavaClass item, ConditionEvents events) {
                boolean notValid = item.getConstructors().stream()
                        .anyMatch(constructor -> constructor.getParameters().size() > maxParameters);
                String message = item.getDescription()
                        + (notValid ? " has" : " does not have")
                        + " a constructor with more than " + maxParameters + " parameters";
                events.add(new SimpleConditionEvent(item, !notValid, message));
            }
        };
    }

    public static @NonNull ArchCondition<JavaClass> maxNofParameterMethodsCondition(int maxParameters) {
        return new ArchCondition<>("have a method with maximum " + maxParameters + " parameters") {
            @Override
            public void check(JavaClass item, ConditionEvents events) {
                boolean notValid = item.getMethods().stream()
                        .anyMatch(method -> method.getParameters().size() > maxParameters);
                System.out.println("notValid = " + notValid);
                String message = item.getDescription()
                        + (notValid ? " has" : " does not have")
                        + " a method with more than " + maxParameters + " parameters";
                events.add(new SimpleConditionEvent(item, !notValid, message));
            }
        };
    }

    public static  ArchCondition<JavaClass> haveNumberOfMethodsLessThanOrEqualTo(int maxMethods) {
        return new ArchCondition<>("have no more than " + maxMethods + " methods") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                int count = javaClass.getMethods().size();
                if (count > maxMethods) {
                    String message = String.format(
                            "Class %s has %d methods, which exceeds the maximum of %d",
                            javaClass.getName(), count, maxMethods
                    );
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    public static  ArchCondition<JavaClass> haveNumberOfPublicMethodsLessThanOrEqualTo(int maxMethods) {
        return new ArchCondition<>("have no more than " + maxMethods + " methods") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {

                javaClass.getMethods().forEach(System.out::println);

                long count = javaClass.getMethods().stream().filter(
                        method -> method.getModifiers().contains(JavaModifier.PUBLIC)).count();
                if (count > maxMethods) {
                    String message = String.format(
                            "Class %s has %d public methods, which exceeds the maximum of %d",
                            javaClass.getName(), count, maxMethods
                    );
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }


    public static  ArchCondition<JavaClass> haveNumberOfLinesLessThanOrEqualTo(int maxLines, final String sourceCodePath) {
        return new ArchCondition<>("have no more than " + maxLines + " lines") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                var path0 = javaClass.getFullName();
                var path = sourceCodePath + path0.replace(".", "/") + ".java";
                long count = countLines(path);
                if (count > maxLines) {
                    String message = String.format(
                            "Class %s has %d lines, which exceeds the maximum of %d",
                            javaClass.getName(), count, maxLines
                    );
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    @SneakyThrows
    public static int countLines(String path) {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        long count = reader.lines().count();
        reader.close();
        return (int) count;
    }


}
