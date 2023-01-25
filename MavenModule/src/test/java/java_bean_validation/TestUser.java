package java_bean_validation;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;


/***
 *   some hassle fixed by
 *   https://stackoverflow.com/questions/43574426/how-to-resolve-java-lang-noclassdeffounderror-javax-xml-bind-jaxbexception
 *   https://stackoverflow.com/questions/36329001/unable-to-create-a-configuration-because-no-bean-validation-provider-could-be-f
 *
 * all constraints:
 *  https://docs.jboss.org/hibernate/beanvalidation/spec/2.0/api/javax/validation/constraints/package-summary.html
 */

@Log
public class TestUser {
    @Test
    public void createNonValidUser() {
        User user=User.builder().name("Alex").email("").build();
        user.logFieldViolations();
        Assert.assertTrue(user.isAnyFieldViolation());
    }

    @Test
    public void createNegAgeUser() {
        User user=User.builder()
                .name("Jonas").age(-48).working(true).email("jonas.hellgren@volvo.com")
                .build();
        System.out.println("user = " + user);
        user.logFieldViolations();
        Assert.assertTrue(user.isAnyFieldViolation());
    }


    @Test
    public void createValidUser() {
        User user=User.builder()
                .name("Jonas").age(48).working(true).mass(95).email("jonas.hellgren@volvo.com")
                .build();
        System.out.println("user = " + user);
        user.logFieldViolations();
        Assert.assertFalse(user.isAnyFieldViolation());
    }

}
