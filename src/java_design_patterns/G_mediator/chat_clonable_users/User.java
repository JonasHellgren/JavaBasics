package java_design_patterns.G_mediator.chat_clonable_users;

public class User implements Cloneable {
    private String name;
    private ChatInterface chat;

    public User(String name, ChatInterface chat) {
        this.name = name;
        this.chat = chat;
        chat.addUser(this);
    }

    public ChatInterface getChat() {
        return chat;
    }

    public void sendMessage(String message, User receiver) {
        chat.sendMessage(this,message,receiver);
    }

    public String getName() {
        return name;
    }

    public User clone() {
        return new User(this.name,this.chat);
    }

}
