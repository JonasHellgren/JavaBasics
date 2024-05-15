package sockets.timer_swing;

public class RunnerServer {
    public static void main(String[] args) {
        int port = 1234; // Define the port to listen on
        TimeServer server = new TimeServer(port);
        server.start();
    }
}
