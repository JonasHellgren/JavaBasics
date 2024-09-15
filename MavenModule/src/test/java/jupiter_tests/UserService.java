package jupiter_tests;

public class UserService {
    public int getUserAge(Long userId) {
        // Mocked logic: Normally, this would fetch data from a database
        if (userId == 1L) {
            return 25;
        } else if (userId == 2L) {
            return -1;  // Invalid age example
        } else {
            return 150; // Another invalid age example
        }
    }
}
