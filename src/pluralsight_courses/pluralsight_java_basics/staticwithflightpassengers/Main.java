package pluralsight_courses.pluralsight_java_basics.staticwithflightpassengers;

import pluralsight_courses.pluralsight_java_basics.staticwithflightpassengers.models.Flight;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Flight f1=new Flight();   Flight f2=new Flight();

        System.out.print("Nof pass f1:"+f1.getnofpass()); System.out.print(". Nof pass f2:"+f2.getnofpass());
        System.out.println(". Tot nof pass f1:"+ Flight.gettotnofpass());
        System.out.println("Let's add 3 passengers to f1."+ Flight.gettotnofpass());
        f1.addpass(3);
        System.out.print("Nof pass f1:"+f1.getnofpass()); System.out.print(". Nof pass f2:"+f2.getnofpass());
        System.out.println(". Tot nof pass f1:"+ f1.gettotnofpass());  //same ...+ Flight.gettotnofpass());
    }
}
