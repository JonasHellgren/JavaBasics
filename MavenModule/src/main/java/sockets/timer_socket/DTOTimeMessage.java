package sockets.timer_socket;

import java.io.Serializable;

public class DTOTimeMessage implements Serializable {
    private boolean isAskingForTime;
    private int time;

    public DTOTimeMessage(boolean isAskingForTime, int time) {
        this.isAskingForTime = isAskingForTime;
        this.time = time;
    }

    public boolean isAskingForTime() {
        return isAskingForTime;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
