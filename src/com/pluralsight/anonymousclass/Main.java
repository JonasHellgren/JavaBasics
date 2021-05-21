package com.pluralsight.anonymousclass;

public class Main {
    public static void main(String[] args) {
        //creation of anonymous class DummyModif extending class Dummy
        Dummy DummyModif = new Dummy() {
            public void display() {   //method display is overriden
                System.out.println("Inside an anonymous class.");
            }
        };

        DummyModif.display();
    }
}
