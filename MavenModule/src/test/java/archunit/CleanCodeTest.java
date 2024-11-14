package archunit;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static archunit.ArchUnitConditions.*;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;


/***
 * skicka hjäölp methoder i JavaCommon
 */

class CleanCodeTest {

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
    void noCyclesInDependenciesInPackage() {
        slices()
                .matching(PACKAGE)
                .should().beFreeOfCycles();
    }

    @Test
    void domainClassesShouldNotDependOnEachOther() {
        String domainPackage = PACKAGE + ".domain";
        noClasses()
                .that().resideInAPackage(domainPackage)
                .should().dependOnClassesThat().resideInAPackage(domainPackage).
                check(classes);
    }

    @Test
    void noClassShouldHaveMoreThan5Fields() {
        int maxFields = 5;
        classes()
                .should(haveNumberOfFieldsLessThanOrEqualTo(maxFields))
                .check(classes);
    }

    @Test
    void maxParamsInConstructors() {
        final int maxParameters = 3;
        classes()
                .that().areNotRecords()
                .should(maxNofParameterCondition(maxParameters)).check(classes);
    }

    @Test
    void maxParamsInMethods() {
        final int maxParameters = 2;
        classes()
                .that().areNotRecords()
                .should(maxNofParameterMethodsCondition(maxParameters)).check(classes);
    }



    @Test
    void noNonRecordClassShouldHaveMoreThan5Methods() {
        int maxMethods = 5;
        classes()
                .that().areNotRecords()
                .should(haveNumberOfMethodsLessThanOrEqualTo(maxMethods))
                .check(classes);
    }

    @Test
    void noRecordClassShouldHaveMoreThan15Methods() {
        int numberOfEqualsHashToStringMethods = 3;
        int nMethodsMax = 10;
        int maxMethods = nMethodsMax + numberOfEqualsHashToStringMethods;
        classes()
                .that().areRecords()
                .should(haveNumberOfPublicMethodsLessThanOrEqualTo(maxMethods))
                .check(classes);
    }



    @Test
    void noClassShouldHaveMoreThan5PublicMethods() {
        int maxMethods = 2;
        classes()
                .that().areNotRecords()
                .should(haveNumberOfPublicMethodsLessThanOrEqualTo(maxMethods))
                .check(classes);
    }



    @Test
    void classesShouldNotExceedMaximumLines() {
        int maxLines = 150;
        classes()
                .should(haveNumberOfLinesLessThanOrEqualTo(maxLines, "src/main/java/"))
                .check(classes);
    }



}
