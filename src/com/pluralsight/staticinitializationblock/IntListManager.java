package com.pluralsight.staticinitializationblock;

import java.util.Random;

public class IntListManager {
    private static final int  NOINTFOUND=-1;
    private static int[] intlist;  //static <=> can access class member without creating an instance

    IntListManager() {};   //class object constructor

    public static void ShowIntlist() {   //prints array intlist
        for (int i = 0; i < intlist.length; i++) {
            System.out.print(intlist[i]);  System.out.print(", ");      }
        System.out.println();    }

        static int FindInt(int intlim) {  //returns first even number lower or eq to intlim in array intlist
        int foundint=NOINTFOUND;
        for (int i=0; i<intlist.length;i++) {
            if (intlist[i] % 2 == 0 && intlist[i]<=intlim) {
                foundint = intlist[i];       break;       }
        }
        return foundint;   }

    //Static initialization block. These lines are executed only the first time the class is used.
    // For ex when method FindInt is called. Handy for file data reading.
    static  {
        intlist = new int[10];  //create int arrray with 10 elements
        Random r = new Random();
        for (int i=0; i<intlist.length;i++)     intlist[i] = r.nextInt(intlist.length);
        ShowIntlist();
    }

}
