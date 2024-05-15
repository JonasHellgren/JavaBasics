package sockets.timer_swing;

import lombok.SneakyThrows;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

class ClientHandler implements Runnable {
    private final Socket clientSocket;
    final long startTime;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.startTime = System.currentTimeMillis();
    }

    @SneakyThrows
    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
            while (!Thread.currentThread().isInterrupted()) {
                long currentTime = (System.currentTimeMillis() - this.startTime) / 1000;
                out.writeObject(currentTime);
                out.flush();
                Thread.sleep(1000); // Send the current time every second
            }
        } catch (IOException  e) {
            System.err.println("Error handling client [" + clientSocket + "]: " + e.getMessage());
        } finally {
            clientSocket.close();
        }
    }
}
