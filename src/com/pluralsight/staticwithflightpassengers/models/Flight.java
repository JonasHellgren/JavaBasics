package com.pluralsight.staticwithflightpassengers.models;

public class Flight {
    //Variables
    int nofpass;   //specific for vreated object
    static int totnofpass;   //static => all objects of the class share the same static variable
    //Constructor
    public void Flight() {nofpass=0; totnofpass=0; }
    //Methods
    public void addpass(int nofadded) {  nofpass=nofpass+nofadded;  totnofpass=totnofpass+nofadded;   }
    public void resettotnofpass() {totnofpass=0;}
    public int getnofpass() {return nofpass;}
    public static int gettotnofpass() {return totnofpass;}
}
