package sockets.timer_swing;

public class RunnerClient {
    public static void main(String[] args) {
        startClientThread(new TimeClient());
    }

    private static void startClientThread(TimeClient client) {
        new Thread(client).start();
    }
}
