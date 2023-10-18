package java_design_patterns.G_mediator_test;

import java_design_patterns.G_mediator.chat_clonable_users.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestChatClonableUser {

    ChatInterface chat;
    User user1;
    User user2;

    @Before
    public void init() {
        chat=new ChatMediator();
        user1=new User("User1",chat);
        user2=new User("User2",chat);
    }

    @Test
    public void send() {
        user1.sendMessage("Hello user 2",user2);
    }

    @Test
    public void whenCloning_thenCorrect() {
        User cloned=user1.clone();
        cloned.sendMessage("Cloned says: Hello user2",user2);

        System.out.println("user1.getChat() = " + user1.getChat());
        System.out.println("cloned.getChat() = " + cloned.getChat());

        Assert.assertEquals(3,chat.nofUser());
        Assert.assertEquals(user1.getChat(),cloned.getChat());  //clone refers to same chat


    }


}
