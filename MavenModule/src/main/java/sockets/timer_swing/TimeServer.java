package sockets.timer_swing;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@Log
public class TimeServer {
    public static final int PORT = 1234;

    @SneakyThrows
    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            log.info("Server started on port " + PORT);
            while (!Thread.currentThread().isInterrupted()) {
                startNewThreadAndLetReplierUseSocket(serverSocket.accept());
            }
        } catch (IOException e) {
            log.info("Could not listen on port " + PORT + ": " + e.getMessage());
        }
    }

    private static void startNewThreadAndLetReplierUseSocket(Socket clientSocket) {
        new Thread(new ClientReplier(clientSocket)).start();
    }
}


