package sockets.timer_swing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class TimeClient implements Runnable {
    private final JLabel timeLabel;
    private final JLabel randomLabel;

    public TimeClient() {
        JFrame frame = new JFrame("Time Viewer");
        timeLabel = new JLabel("Time", SwingConstants.CENTER);
        frame.add(timeLabel, BorderLayout.NORTH);
        randomLabel = new JLabel("Random nr", SwingConstants.CENTER);
        frame.add(randomLabel, BorderLayout.SOUTH);
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {
            try(Socket socket = new Socket("localhost", TimeServer.PORT)) {
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            while (!Thread.currentThread().isInterrupted()) {
                readFromServerAndSetLabelTexts(input);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFromServerAndSetLabelTexts(ObjectInputStream input) throws IOException, ClassNotFoundException {
        DTO dto = (DTO) input.readObject();
        SwingUtilities.invokeLater(() -> {
            timeLabel.setText("Time: " + dto.time() + " seconds");
            randomLabel.setText("Random: " + dto.randDouble());
        });
    }
}

