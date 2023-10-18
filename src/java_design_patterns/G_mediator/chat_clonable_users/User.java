package java_design_patterns.G_mediator.chat_clonable_users;

import lombok.SneakyThrows;

public class User implements Cloneable {
    private final String name;
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

    /***
     * Insight from code below: clone() must execute the same as the constructor
     */

    @SneakyThrows
    public User clone() {
        User clone=(User) super.clone();
        clone.chat=this.chat;
        chat.addUser(clone);
        return clone;
        //return new User(this.name,this.chat); //works as well
    }

}
