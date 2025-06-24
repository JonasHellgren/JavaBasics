package sockets.time_shower;// TimeServer.java
import lombok.extern.java.Log;

import java.io.*;
import java.net.*;
import java.time.LocalTime;

@Log
public class TimeServer {
    public static final int PORT = 2024;
    private static volatile String time = "Initializing...";


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server waiting for client...");

        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());

        // Start sender thread
        Thread senderThread = new Thread(() -> {
            try {
                while (true) {
                    out.writeObject(new TimePacket(time));
                    out.flush();
                    Thread.sleep(1000);
                }
            } catch (IOException | InterruptedException e) {
                System.out.println("TimeSender stopped: " + e.getMessage());
            }
        });
        senderThread.setDaemon(true);
        senderThread.start();

        // Main thread updates the shared time
        while (true) {
            time = LocalTime.now().withNano(0).toString();
            try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        }
    }
}
