package pluralsight_courses.pluralsight_java_basics.leapyear;

//A year is a leap year if it is divisable by four, but...
//years divisable by 100 are not leap years except years divisable by 400
//For example, the years 1700, 1800, and 1900 are not leap years, but the years 1600 and 2000 are.
public class LeapYear {
    public static boolean isLeapYear(int year) {
        return ( (isDivisible(year,4) && !isDivisible(year,100))  || isDivisible(year,400));  }

    public static boolean isDivisible(int year,int denominator)   {
        return year % denominator==0; }
}
