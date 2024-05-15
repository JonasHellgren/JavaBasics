package sockets.timer_swing;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class TimeClient implements Runnable {
    private final JLabel timeLabel;

    public TimeClient() {
        JFrame frame = new JFrame("Time Viewer");
        timeLabel = new JLabel("Time will be displayed here", SwingConstants.CENTER);
        frame.add(timeLabel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void run() {
            // Assume the server is running
            try(Socket socket = new Socket("localhost", TimeServer.PORT)) {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            while (!Thread.currentThread().isInterrupted()) {
                long time = (long) input.readObject();  // Read time from server
                String timeText = "Time: " + time + " seconds";
                SwingUtilities.invokeLater(() -> timeLabel.setText(timeText));
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

