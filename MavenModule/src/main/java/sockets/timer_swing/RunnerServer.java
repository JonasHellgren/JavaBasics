package sockets.timer_swing;

import lombok.extern.java.Log;

@Log
public class RunnerServer {
    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        server.start();
    }
}
