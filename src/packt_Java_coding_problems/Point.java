package packt_Java_coding_problems;

import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
public class Point implements Cloneable {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /*
    public Point clone () throws CloneNotSupportedException {
        return (Point) super.clone();
    }  */

    @Override
    public Point clone () {
        return new Point(this.x,this.y);
    }


}