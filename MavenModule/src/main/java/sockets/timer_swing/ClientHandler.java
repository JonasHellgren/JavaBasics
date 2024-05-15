package sockets.timer_swing;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
    class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public ClientHandler(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream())) {
                while (!Thread.currentThread().isInterrupted()) {
                    long currentTime = System.currentTimeMillis() / 1000;
                    out.writeObject(currentTime);
                    out.flush();
                    Thread.sleep(1000); // Send the current time every second
                }
            } catch (IOException | InterruptedException e) {
                System.err.println("Error handling client [" + clientSocket + "]: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.err.println("Error closing client socket: " + e.getMessage());
                }
            }
        }
}
