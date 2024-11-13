package archunit;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaModifier;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;
import lombok.NonNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

class CleanCodeTest {

    // Define limits for maximum fields,  methods, private methods, and lines of code
    private static final int MAX_FIELDS = 5;
    private static final int MAX_PUBLIC_METHODS = 5;
    private static final int MAX_PRIVATE_METHODS = 5;
    private static final int MAX_LINES = 200;
    static final String PACKAGE = "mockito.book_repo";


    private static JavaClasses classes;

    @BeforeAll
    static void beforeAll() {
        classes = new ClassFileImporter().importPackages(PACKAGE);
    }

    @Test
    void servicesShouldAccessRepos() {
        classes()
                .that().resideInAPackage("..service..")
                .should().accessClassesThat().resideInAPackage("..repo..")
                .because("Services should use repos")
                .check(classes);
    }

    @Test
    void noReposShouldAccessServices() {
        noClasses()
                .that().resideInAPackage("..repo..")
                .should().accessClassesThat().resideInAPackage("..service..")
                .because("Repos should not use services")
                .check(classes);
    }

    @Test
    void fieldsOutsidePackageConfigShallBeFinalAndPrivate() {
        fields()
                .that().areDeclaredInClassesThat().resideOutsideOfPackage("..config..")
                .should()
                .beFinal().andShould().bePrivate()
                .because("Repos should not use services")
                .check(classes);
    }

    @Test
    void utilityClassesShouldHaveProtectedConstructor() {
        classes().that(areUtilClasses)
                .should().haveOnlyPrivateConstructors()
                .because("Utility classes should not be created").allowEmptyShould(true)
                .check(classes);
    }

    DescribedPredicate<JavaClass> areUtilClasses =
            new DescribedPredicate<>("are utility classes") {
                @Override
                public boolean test(final JavaClass input) {
                    return input.getSimpleName().endsWith("Util");
                }
            };


    @Test
    void onlyConfigurationClassesShouldHaveStaticFields() {
        fields()
                .that().areDeclaredInClassesThat().resideInAPackage("..config")
                .should().beStatic()
                .because("Static fields should be contained within configuration classes only")
                .check(classes);
    }

    @Test
    void configurationClassesShouldHavePrivateConstructors() {
        constructors()
                .that().areDeclaredInClassesThat().resideInAPackage("..config")
                .should().bePackagePrivate()
                .because("Not create config classes")
                .check(classes);
    }

    @Test
    void interfaceClassesShouldEndWithI() {
        classes()
                .that().areInterfaces()
                .should().haveSimpleNameEndingWith("I")
                .check(classes);
    }

    @Test
    void noClassShouldHaveMoreThan5Fields() {
        int maxFields = 5;
        classes()
                .should(haveNumberOfFieldsLessThanOrEqualTo(maxFields))
                .check(classes);
    }

    ArchCondition<JavaClass> haveNumberOfFieldsLessThanOrEqualTo(int maxFields) {
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

    @Test
    void maxParamsInConstructors() {
        final int maxParameters = 3;
        classes()
                .that().areNotInterfaces()
                .should(maxNofParameterCondition(maxParameters)).check(classes);
    }

    private static @NonNull ArchCondition<JavaClass> maxNofParameterCondition(int maxParameters) {
        return new ArchCondition<>("have a constructor with maximum " + maxParameters + " parameters") {
            @Override
            public void check(JavaClass item, ConditionEvents events) {
                boolean valid = item.getConstructors().stream()
                        .anyMatch(constructor -> constructor.getParameters().size() <= maxParameters);
                String message = item.getDescription()
                        + (valid ? " has" : " does not have")
                        + " a constructor with more than " + maxParameters + " parameters";
                events.add(new SimpleConditionEvent(item, valid, message));
            }
        };
    }

    @Test
    void noClassShouldHaveMoreThan15Methods() {
        int maxMethods = 15;
        classes()
                .that().areNotRecords()
                .should(haveNumberOfMethodsLessThanOrEqualTo(maxMethods))
                .check(classes);
    }

    ArchCondition<JavaClass> haveNumberOfMethodsLessThanOrEqualTo(int maxMethods) {
        return new ArchCondition<>("have no more than " + maxMethods + " methods") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                int count = javaClass.getMethods().size();
                if (count > maxMethods) {
                    String message = String.format(
                            "Class %s has %d fields, which exceeds the maximum of %d",
                            javaClass.getName(), count, maxMethods
                    );
                    events.add(SimpleConditionEvent.violated(javaClass, message));
                }
            }
        };
    }

    @Test
    void noClassShouldHaveMoreThan5PublicMethods() {
        int maxMethods = 2;
        classes()
                .that().areNotRecords()
                .should(haveNumberOfPublicMethodsLessThanOrEqualTo(maxMethods))
                .check(classes);
    }

    ArchCondition<JavaClass> haveNumberOfPublicMethodsLessThanOrEqualTo(int maxMethods) {
        return new ArchCondition<>("have no more than " + maxMethods + " methods") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                long count =  javaClass.getMethods().stream().filter(
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

    @Test
    void classesShouldNotExceedMaximumLines() {
        int maxLines = 2;
        classes()
                .that().areNotRecords()
                .should(haveNumberOfLinesLessThanOrEqualTo(maxLines))
                .check(classes);
    }

    ArchCondition<JavaClass> haveNumberOfLinesLessThanOrEqualTo(int maxLines) {
        return new ArchCondition<>("have no more than " + maxLines + " lines") {
            @Override
            public void check(JavaClass javaClass, ConditionEvents events) {
                long count =  10;  //TODO FEL !!!!!!!!!!!!!!!!!
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

}
