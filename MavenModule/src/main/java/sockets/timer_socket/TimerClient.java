package sockets.timer_socket;

import lombok.SneakyThrows;
import lombok.extern.java.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

@Log
public class TimerClient {
    private final String host;
    private final int port;

    public TimerClient(String host, int port) throws IOException {
        this.host = host;
        this.port = port;
    }


    public void askTime()  throws IOException, ClassNotFoundException {
        while (true) {
            try (Socket socket = new Socket(host, port);
                 ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                 ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

                while (!socket.isClosed()) {
                    try {
                        DTOTimeMessage request = new DTOTimeMessage(true, 0);
                        out.writeObject(request);
                        out.reset();  // Reset the output stream to ensure no caching of the objects
                        out.flush();

                        DTOTimeMessage response = (DTOTimeMessage) in.readObject();
                        System.out.println("Current time on server: " + response.getTime());

                        Thread.sleep(1000);  // Delay between requests
                    } catch (IOException e) {
                        System.err.println("IOException during communication, attempting to reconnect: " + e.getMessage());
                        break;  // Exit the inner loop to close socket and recreate it
                    }
                }
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                System.err.println("Error, attempting to reconnect: " + e.getMessage());
                try {
                    Thread.sleep(1000);  // Wait before attempting to reconnect
                } catch (InterruptedException ie) {
                    System.err.println("Interrupted during sleep: " + ie.getMessage());
                }
            }
        }
    }
    

}