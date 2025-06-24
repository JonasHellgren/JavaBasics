package sockets.time_shower;// TimePacket.java
import java.io.Serializable;

public class TimePacket implements Serializable {
    public final String time;
    public TimePacket(String time) {
        this.time = time;
    }
}
