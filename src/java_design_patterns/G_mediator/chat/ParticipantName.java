package java_design_patterns.G_mediator.chat;

public class ParticipantName implements ParticipantInterface{
    private String name;
    private ChatRoomInterface chat;

    public ParticipantName(ChatRoomInterface chat, String name){
        this.chat=chat;
        this.name=name;
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
