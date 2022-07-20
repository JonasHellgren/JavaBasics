package java_design_patterns.G_mediator_test;

import java_design_patterns.G_mediator.chat.*;
import org.junit.Test;

public class TestChat {

    @Test
    public void test() {

        ChatRoomInterface chat=new ChatRoom();
        ParticipantInterface p1=new ParticipantName(chat,"Jonas");
        ParticipantInterface p2=new ParticipantNameAndAge(chat,"Alex",4);

        p1.sendMsg("Hi Alex, how are you?");
        p2.sendMsg("Im fine, and you?");


    }
}
