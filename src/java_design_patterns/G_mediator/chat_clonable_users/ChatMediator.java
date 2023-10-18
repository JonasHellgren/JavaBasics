package java_design_patterns.G_mediator.chat_clonable_users;

import java.util.ArrayList;
import java.util.List;

public class ChatMediator implements ChatInterface {

    private final List<User> userList;

    public ChatMediator() {
        this.userList=new ArrayList<>();
    }

    public void addUser(User user) {
        this.userList.add(user);
    }

    @Override
    public void sendMessage(User sender, String message, User receicer) {
        System.out.println(sender.getName()+" sends: "+message+" to "+receicer.getName());
    }


    @Override
    public int nofUser() {
        return userList.size();
    }
}
