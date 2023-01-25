package java_bean_validation;

import lombok.Builder;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
@Setter
@ToString
@Log
public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue (message = "working must be true")
    private boolean working;

    @Size(min = 10, max = 200, message
            = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Min(value = 1, message = "Age should not be less than 18")
    @Max(value = 250, message = "Age should not be greater than 150")
    private Integer mass;

    @PositiveOrZero (message = "age must be positive")
    private Integer age;

    @Size(min = 2, max = 24)
    private String email;

    public boolean isAnyFieldViolation() {
        List<String> violationList= getFieldViolations();
        return !violationList.isEmpty();
    }

    public List<String> getFieldViolations() {

        List<String> violationList=new ArrayList<>();
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(this);
        for (ConstraintViolation<User> violation : violations) {
            violationList.add(violation.getMessage());
        }
        return violationList;

    }

    public void logFieldViolations() {
        List<String> violationList= getFieldViolations();
        for (String violationText:violationList) {
            log.warning(violationText);
        }
    }

}
