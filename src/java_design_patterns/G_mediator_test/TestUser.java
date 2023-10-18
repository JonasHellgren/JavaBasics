package java_design_patterns.G_mediator_test;

import java_design_patterns.G_mediator.user_with_clone.*;
import lombok.SneakyThrows;

public class TestUser {

    @SneakyThrows
    public static void main(String[] args) {
        UserMediator mediator = new UserMediator();
        User user1 = new User("Alice", mediator);
        user1.addFriend("Bob");
        user1.addFriend("Charlie"); // Clone user1
        User user2 = (User) user1.clone();
        user2.addFriend("David");

        user1.displayInfo();    //Friends: [Bob, Charlie]
        user2.displayInfo();    //Friends: [Bob, Charlie, David]

        System.out.println("user1.getMediator() = " + user1.getMediator());
        System.out.println("user2.getMediator() = " + user2.getMediator());
        //different mediators

    }

}

