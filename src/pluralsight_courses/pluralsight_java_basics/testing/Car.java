package pluralsight_courses.pluralsight_java_basics.testing;

public class Car {
    private Double spd;
    Car(Double spd0) {this.spd=spd0;}   //constructor
    public void UpdSpd(Double a,Double dt)  {   //method to update spd
        if (dt==0) DtisZeroExc();   //call exception handler if true
                this.spd = this.spd + a * dt;
       }
    public Double GetSpd () {return this.spd;}  //getter

    public static void DtisZeroExc() {  //exception handler
        System.out.println("Trying to have dt as zero\"");
        throw new IllegalArgumentException();
    }

}



