package sockets.timer_swing;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.apache.commons.lang.math.RandomUtils;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Log
class ClientReplier implements Runnable {
    private final Socket clientSocket;
    final long startTime;

    public ClientReplier(Socket clientSocket) {
        log.info("Client connected, creating replier");
        this.clientSocket = clientSocket;
        this.startTime = System.currentTimeMillis();
    }

    @SneakyThrows
    @Override
    public void run() {
        try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
            while (!Thread.currentThread().isInterrupted()) {
                out.writeObject( createDto());
                out.flush();
                Thread.sleep(1000); // Send the current time every second
            }
        } catch (IOException  e) {
            log.warning("Error handling client [" + clientSocket + "]: " + e.getMessage());
        } finally {
            clientSocket.close();
        }
    }

    private DTO createDto() {
        long currentTime = (System.currentTimeMillis() - this.startTime) / 1000;
        return new DTO(currentTime, RandomUtils.nextDouble());
    }
}
