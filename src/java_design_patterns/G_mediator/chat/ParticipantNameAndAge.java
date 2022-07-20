package java_design_patterns.G_mediator.chat;

public class ParticipantNameAndAge implements ParticipantInterface {
    private String name;
    private ChatRoomInterface chat;
    private int age;

    public ParticipantNameAndAge(ChatRoomInterface chat, String name, int age){
        this.chat=chat;
        this.name=name;
        this.age=age;
    }

    @Override
    public void sendMsg(String msg) {
        chat.showMsg(msg,this);

    }



    @Override
    public String getName() {
        return name;
    }

}
