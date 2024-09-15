package jupiter_tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

 class TestUserService {
    private final UserService userService = new UserService();

    @Test
     void testUserAge_Valid() {
        Long validUserId = 1L;
        int age = userService.getUserAge(validUserId);

        assertTrue(age >= 0,
                () -> "Invalid age: Age for user with ID " + validUserId + " is " + age + ", expected non-negative.");

        assertTrue(age <= 120,
                () -> "Invalid age: Age for user with ID " + validUserId + " is " + age + ", exceeds maximum allowed value.");
    }

    @Test
     void testUserAge_InvalidNegative() {
        Long invalidUserId = 2L;
        int age = userService.getUserAge(invalidUserId);

        assertTrue(age >= 0,
                () -> "Invalid age: Age for user with ID " + invalidUserId + " is " + age + ", expected non-negative.");
    }

    @Test
     void testUserAge_InvalidTooHigh() {
        Long invalidUserId = 3L;
        int age = userService.getUserAge(invalidUserId);

        assertTrue(age <= 120,
                () -> "Invalid age: Age for user with ID " + invalidUserId + " is " + age + ", exceeds maximum allowed value.");
    }
}
