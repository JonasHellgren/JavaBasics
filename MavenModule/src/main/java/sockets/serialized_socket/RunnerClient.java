package sockets.serialized_socket;

import lombok.extern.java.Log;
import java.io.IOException;

@Log
public class RunnerClient {


    public static void main(String[] args) {
        try {
            Client client = new Client(Server.PORT);
            client.handleClient();  // Handle a single client connection
            client.stop();
        } catch (IOException | ClassNotFoundException e) {
            log.warning("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
