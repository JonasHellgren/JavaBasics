package java_design_patterns.G_mediator.user_with_clone;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserMediator implements Cloneable {
    private List<String> friends;

    public UserMediator() {
        friends = new ArrayList<>();
    }

    public void addFriend(String friendName) {
        friends.add(friendName);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        UserMediator clone = (UserMediator) super.clone(); // Clone the list of friends
        clone.friends = new ArrayList<>(this.friends);
        return clone;
    }

}
