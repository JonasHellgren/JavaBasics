package sockets.timer_swing;

public class RunnerClient {
    public static void main(String[] args) {
        TimeClient client = new TimeClient();
        new Thread(client).start();  // Start the client thread
    }
}
