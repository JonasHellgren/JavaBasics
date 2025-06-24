package sockets.time_shower;

import lombok.*;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;

@Log
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeGfxServer {

    private int port;
    private int sleepTime;
    @Setter
    volatile GfxDTO gfxDTO;

    public static TimeGfxServer of(int port, int sleepTime) {
        var server = new TimeGfxServer(port, sleepTime, GfxDTO.empty());
        server.init();
        return server;
    }

    @SneakyThrows
    private void init() {
        var out = getOutputStream();
        var senderThread = getSenderThread(out);
        senderThread.setDaemon(true);
        senderThread.start();
    }

    private Thread getSenderThread(ObjectOutputStream out) {
        return new Thread(() -> {
            try {
                while (true) {
                    out.writeObject(gfxDTO);
                    out.flush();
                    log.info("time = " + gfxDTO);
                    Thread.sleep(sleepTime);
                }
            } catch (IOException | InterruptedException e) {
                log.info("TimeSender stopped: " + e.getMessage());
            }
        });
    }

    private ObjectOutputStream getOutputStream() throws IOException {
        var serverSocket = new ServerSocket(port);
        log.info("Server waiting for client...");
        var clientSocket = serverSocket.accept();
        log.info("Client connected.");
        return new ObjectOutputStream(clientSocket.getOutputStream());
    }

}
