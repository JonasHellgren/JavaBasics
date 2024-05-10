package sockets.serialized_socket;

import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

@Log
public class Client {
    private final Socket socket;

    public Client(int port) throws IOException {
        socket = new Socket("localhost", Server.PORT);
        log.info("Client started on port: " + port);
    }

    public void handleClient() throws IOException, ClassNotFoundException {
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        Packet packet = new Packet("Hello");
        out.writeObject(packet);
        Packet packetReceived = (Packet) in.readObject();
        log.info("Packet received = " + packetReceived.message);

    }

    public void stop() throws IOException {
        socket.close();
        log.info("Server stopped.");
    }

}
