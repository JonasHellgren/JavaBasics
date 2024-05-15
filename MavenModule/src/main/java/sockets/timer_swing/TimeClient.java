package sockets.timer_swing;

import javax.swing.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class TimeClient implements Runnable {
    private JFrame frame;
    private JLabel timeLabel;

    public TimeClient() {
        frame = new JFrame("Time Viewer");
        timeLabel = new JLabel("Time will be displayed here", SwingConstants.CENTER);
        frame.add(timeLabel);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void run() {
        try {
            // Assume the server is running on localhost and port 1234
            Socket socket = new Socket("localhost", 1234);
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

