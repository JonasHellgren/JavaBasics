package sockets.timer_swing;

import java.io.Serializable;

public record DTO  (
        long time,
        double randDouble
) implements Serializable {
}
