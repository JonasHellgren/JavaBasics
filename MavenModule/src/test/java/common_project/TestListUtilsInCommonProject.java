package common_project;

import org.hellgren.utilities.list_arrays.MyListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * Uses class/method in other project, dependency in pam file
 * Here’s a summary of the steps to export a class from the JavaCommon project to the JavaBasics project:

 * Install JavaCommon Locally:

 * Navigate to the JavaCommon project directory.
 * Run mvn install to install the JavaCommon JAR in your local Maven repository.

 * Add JavaCommon as a Module in JavaBasic (or any project needing JavaCommon):
 * Go to File > Project Structure > Modules in IntelliJ IDEA.
 * Import JavaCommon as a module.
 * Add Dependency in JavaBasics:

 * In JavaBasics's pom.xml, add:
 * <dependency>
 *     <groupId>org.hellgren</groupId>
 *     <artifactId>JavaCommon</artifactId>
 *     <version>1.0-SNAPSHOT</version>
 * </dependency>
 *
 */

 class TestListUtilsInCommonProject {


    @Test
    void whenFindMi_thenCorrect() {

        var list= List.of(1d,2d,3d);
       double min= MyListUtils.findMin(list).orElseThrow();
        Assertions.assertEquals(1d,min);

    }
}
