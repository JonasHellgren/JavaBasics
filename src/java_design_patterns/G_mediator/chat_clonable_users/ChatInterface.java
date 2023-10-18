package java_design_patterns.G_mediator.chat_clonable_users;

public interface ChatInterface {
    void sendMessage(User sender, String message, User receicer);
    void addUser(User user);
    int nofUser();
}
