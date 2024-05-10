package sockets.timer_socket;

import lombok.SneakyThrows;

import java.io.IOException;

public class RunnerTimeServer {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            TimerServer server = new TimerServer(2024);
//            server.listen();

            // Start server listen in a new thread
            new Thread(() -> {
                try {
                    server.listen();
                } catch (IOException e) {
                    System.err.println("Error running server: " + e.getMessage());
                }
            }).start();

            // Additional tasks can be performed here while the server listens
            System.out.println("Server is running... Main thread is free for other tasks.");


        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
