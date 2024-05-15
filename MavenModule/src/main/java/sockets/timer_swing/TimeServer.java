package sockets.timer_swing;

import lombok.SneakyThrows;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static final int PORT = 1234;


    @SneakyThrows
    public void start() {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started on port " + PORT);
            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start(); // Start a new thread for each client
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + PORT + ": " + e.getMessage());
        }
    }
}


