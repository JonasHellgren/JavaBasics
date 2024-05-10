package sockets.timer_socket;

import lombok.SneakyThrows;

import java.io.IOException;

public class RunnerTimerClient {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            TimerClient client = new TimerClient("localhost", 2024);
            client.askTime();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
