package sockets.serialized_socket;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Log
public class Server {
    public static final int PORT = 2024;
    private final ServerSocket socket;

    public Server(int port) throws IOException {
        socket = new ServerSocket(port);
        log.info("Server started on port: " + port);
    }

    public void handleClient() throws IOException, ClassNotFoundException {
        try (Socket socket = this.socket.accept();
             ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

            log.info("Client connected.");
            Packet packetReceived = (Packet) in.readObject();
            log.info("Packet received = " + packetReceived.message);

            if ("Hello".equals(packetReceived.message)) {
                Packet responsePacket = new Packet("Hi from server");
                out.writeObject(responsePacket);
            }
        }
    }

    public void stop() throws IOException {
        socket.close();
        log.info("Server stopped.");
    }

}
