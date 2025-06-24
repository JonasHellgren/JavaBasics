package sockets.time_shower;// TimeClient.java
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class TimeClient {
    private final JLabel timeLabel = new JLabel("Waiting...", SwingConstants.CENTER);
    private final JFrame frame = new JFrame("Time Client");

    public TimeClient() {
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(timeLabel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void start() throws IOException, ClassNotFoundException {
        Socket socket = new Socket("localhost", 2024);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

        while (true) {
            var gfxDTO = (GfxDTO) in.readObject();
            SwingUtilities.invokeLater(()
                    -> timeLabel.setText("Time: " + gfxDTO.time()));
        }
    }

    public static void main(String[] args) throws Exception {
        TimeClient client = new TimeClient();
        client.start();
    }
}
