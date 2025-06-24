package sockets.time_shower;// TimePacket.java
import java.io.Serializable;

public record GfxDTO(
        String time
) implements Serializable {

    public static GfxDTO of(String time) {
        return new GfxDTO(time);
    }

    public static GfxDTO empty() {
        return new GfxDTO("Initializing...");
    }
}
