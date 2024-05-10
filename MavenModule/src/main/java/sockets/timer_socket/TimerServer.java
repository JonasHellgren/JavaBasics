package sockets.timer_socket;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

@Log
public class TimerServer {
    private final ServerSocket serverSocket;
    private int currentTime = 0;

    public TimerServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Timer Server started on port: " + port);
        startTimer();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                currentTime++;
            }
        }, 1000, 1000);
    }

    public void listen() throws IOException {
        System.out.println("Server is listening...");
        while (true) {
            try (
                    Socket socket = serverSocket.accept();
                    ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                    ObjectInputStream in = new ObjectInputStream(socket.getInputStream())
            )
            {

                while (!socket.isClosed()) {
                    DTOTimeMessage message = (DTOTimeMessage) in.readObject();
                    if (message.isAskingForTime()) {
                        log.info("Setting time");
                        message.setTime(currentTime);
                        out.writeObject(message);
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error handling client: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void stop() throws IOException {
        serverSocket.close();
        System.out.println("Server stopped.");
    }
}
