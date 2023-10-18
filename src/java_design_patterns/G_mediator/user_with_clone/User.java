package java_design_patterns.G_mediator.user_with_clone;

import lombok.Getter;

@Getter
public class User implements Cloneable {
    private final String username;
    private UserMediator mediator;

    public User(String username, UserMediator mediator) {
        this.username = username;
        this.mediator = mediator;
    }

    public void addFriend(String friendName) {
        mediator.addFriend(friendName);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        User clone = (User) super.clone();
        // Clone the UserMediator
        clone.mediator = (UserMediator) this.mediator.clone();
        return clone;
    }

    public void displayInfo() {
        System.out.println("Username: " + username);
        System.out.println("Friends: " + mediator.getFriends());
    }
}


