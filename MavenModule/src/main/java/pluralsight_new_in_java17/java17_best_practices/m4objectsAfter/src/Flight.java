package pluralsight_new_in_java17.java17_best_practices.m4objectsAfter.src;


import lombok.Getter;

import java.util.Objects;

@Getter
public class Flight {

    private String fromDest;
    private String toDest;
    private String date;

    public Flight(String fromDest, String toDest, String date) {
        this.fromDest = checkValidDest(fromDest);
        this.toDest = toDest;
        this.date = date;
    }

    private String checkValidDest(String fromDest) {  //added
        if (Objects.isNull(fromDest)) {
            throw new IllegalArgumentException();
        }
        return fromDest;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "fromDest='" + fromDest + '\'' +
                ", toDest='" + toDest + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
