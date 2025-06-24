package sockets.time_shower;// TimeServer.java
import lombok.extern.java.Log;

import java.io.*;
import java.time.LocalTime;

@Log
public class TimeServer {
    public static final int PORT = 2024;
    public static final int SLEEP_TIME_IN_MS = 100;

    public static void main(String[] args) throws IOException {

        var gfxServer= TimeGfxServer.of(PORT, SLEEP_TIME_IN_MS);

        // Main thread updates the GfxGTO
        while (true) {
            var time = LocalTime.now().withNano(0).toString();
            gfxServer.setGfxDTO(GfxDTO.of(time));
            log.info("time = " + time);
            try { Thread.sleep(SLEEP_TIME_IN_MS); } catch (InterruptedException ignored) {}
        }
    }
}
