package sockets.serialized_socket;

import java.io.IOException;

public class RunnerServer {

    public static final int PORT = 2024;

    public static void main(String[] args) {
        try {
            Server server = new Server(PORT);
            server.handleClient();  // Handle a single client connection
            server.stop();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
