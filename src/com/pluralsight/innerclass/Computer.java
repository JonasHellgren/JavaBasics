package com.pluralsight.innerclass;

public class Computer {
    private String name;
    Computer(String str) { this.name=str;  }  //constructor
    String getName() {return name;}

    class Processor{    // inner class
        int flops;
        Processor(){    SetFlops();};  //constructor
        void SetFlops() {   //method that set flops depending on var in outer class
            switch (Computer.this.name) {
                case "i3": flops = 1000;  break;
                case "i5": flops = 2000;  break;
                default:  System.out.println("No match");  flops = -1;
            }
        }
        int getFlops() {return flops;}
    }
}
