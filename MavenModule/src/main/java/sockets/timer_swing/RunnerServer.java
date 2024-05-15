package sockets.timer_swing;

public class RunnerServer {
    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        server.start();
    }
}
