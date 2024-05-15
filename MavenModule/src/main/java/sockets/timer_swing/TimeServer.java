package sockets.timer_swing;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    private final int port;
    private ServerSocket serverSocket;

    public TimeServer(int port) {
        this.port = port;
    }

    @SneakyThrows
    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port " + port);

            while (!Thread.currentThread().isInterrupted()) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start(); // Start a new thread for each client
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + port + ": " + e.getMessage());
        } finally {
            try {
                if (serverSocket != null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing server socket: " + e.getMessage());
            }
        }
    }
}


