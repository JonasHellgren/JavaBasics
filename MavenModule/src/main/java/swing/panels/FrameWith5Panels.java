package swing.panels;

import com.google.common.base.Preconditions;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.IntStream;

public class FrameWith5Panels {

    public static final int WEIGHT0 = 120;
    public static final int HEIGHT_ONE_ROW = 12;

    public static final int HEIGHT_PANEL = HEIGHT_ONE_ROW*10;
    public static final int N_SLOTS=5;
    public static final int GAP = 5;
    public static final String AIRCRAFT_PNG = "MavenModule/src/main/java/swing/figs/aircraft.png";
    public static final int WEIGHT_CRAFT_ICON = WEIGHT0/2;
    public static final int HEIGHT_CRAFT_ICON = HEIGHT_ONE_ROW*3;
    public static final int MAX_PROGRESS = 100;
    public static final int MIN_PROGRESS = 0;
    public static final int DEFAULT_PRGORESS = 0;

    public static void main(String[] args) {
            // Create the frame on the event dispatching thread
            SwingUtilities.invokeLater(FrameWith5Panels::createAndShowGUI);
        }

        private static void createAndShowGUI() {
            // Create the frame
            JFrame frame = new JFrame("Frame with Custom Sized Panels");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Main panel with BoxLayout along Y-axis
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

            // First row panel with FlowLayout (or BoxLayout)
            JPanel row1 = new JPanel();
            row1.setLayout(new FlowLayout(FlowLayout.LEFT, GAP, GAP));

            // Second row panel with FlowLayout (or BoxLayout)
            JPanel row2 = new JPanel();
            row2.setLayout(new FlowLayout(FlowLayout.LEFT, GAP, GAP));

            // Create panels with specified widths
            JPanel panel1 = createPanel(Color.BLUE, WEIGHT0*(N_SLOTS+1)+GAP*(N_SLOTS), HEIGHT_PANEL);
            JPanel panel2 = createPanel(Color.LIGHT_GRAY, WEIGHT0, HEIGHT_PANEL);
            JPanel panel3 = createPanel(Color.LIGHT_GRAY, WEIGHT0, HEIGHT_PANEL);
            List<JPanel> slots=new ArrayList<>();
            IntStream.range(MIN_PROGRESS,N_SLOTS).forEach(si -> slots.add(createSlotPanel(si,Color.GRAY, WEIGHT0, HEIGHT_PANEL)));
            JPanel panel5 = createPanel(Color.LIGHT_GRAY, WEIGHT0, HEIGHT_PANEL);

            // Add panels to their respective rows
            row1.add(panel1);
            row1.add(panel2);
            row2.add(panel3);
            slots.forEach(s -> row2.add(s));
            row2.add(panel5);

            // Add rows to the main panel
            mainPanel.add(row1);
            mainPanel.add(row2);

            // Add main panel to the frame
            frame.add(mainPanel);

            // Display the frame
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        }

        private static JPanel createPanel(Color color, int width, int height) {
            JPanel panel = new JPanel();
            panel.setBackground(color);
            panel.setPreferredSize(new Dimension(width, height));
            return panel;
        }

    private static JPanel createSlotPanel(int si,Color color, int width, int height) {
        String file = AIRCRAFT_PNG;
        Preconditions.checkArgument(Files.exists(Paths.get(file)),"File does not exist, file="+file);
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBackground(color);
        panel.setPreferredSize(new Dimension(width, height));
        ImageIcon imageIcon = new ImageIcon(file);
        ImageIcon resizedIcon = getImageIconScaled(width, height, imageIcon);
        JLabel labelCraft = new JLabel(String.valueOf(si), resizedIcon, SwingConstants.CENTER);
        panel.add(labelCraft);

        panel.add(createProgressBar(width, "soc=", DEFAULT_PRGORESS, MAX_PROGRESS, ""));
        int timeProgress = 10;
        int maxTime = 30;
        panel.add(createProgressBar(width, "time=", timeProgress, maxTime, ""));
        double power = 10e3;
        double powerMax = 100e3;
        panel.add(createProgressBar(width, "power=", power, powerMax, ""));
        double powerRequired = 10e3;
        panel.add(createProgressBar(width, "rp=", powerRequired, powerMax, ""));
        return panel;
    }

    public static final DecimalFormatSymbols SYMBOLS = new DecimalFormatSymbols(Locale.US); //US <=> only dots
    public static final DecimalFormat formatterNoDigit = new DecimalFormat("#", SYMBOLS);

    private static JProgressBar createProgressBar(int width, String measureName, double value, double maxProgress, String unit) {
        JProgressBar progressBar = new JProgressBar(MIN_PROGRESS, (int) maxProgress);
        progressBar.setValue((int) value);
        progressBar.setStringPainted(true);  // to show progress text
        progressBar.setString(measureName + formatterNoDigit.format(value) + unit);
        progressBar.setPreferredSize(new Dimension(width, HEIGHT_ONE_ROW));
        return progressBar;
    }

    private static ImageIcon getImageIconScaled(int width, int height, ImageIcon imageIcon) {
        Image image = imageIcon.getImage();
        Image resizedImage = image.getScaledInstance(
                WEIGHT_CRAFT_ICON,HEIGHT_CRAFT_ICON,Image.SCALE_SMOOTH);
        return new ImageIcon(resizedImage);
    }

}
