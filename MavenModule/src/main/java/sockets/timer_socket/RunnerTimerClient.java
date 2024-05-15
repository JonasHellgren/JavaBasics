package sockets.timer_socket;

import lombok.SneakyThrows;

import java.io.IOException;

public class RunnerTimerClient {
    @SneakyThrows
    public static void main(String[] args) {
        try {
            TimerClientPrintText client = new TimerClientPrintText("localhost", 2024);
            client.askTime();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
