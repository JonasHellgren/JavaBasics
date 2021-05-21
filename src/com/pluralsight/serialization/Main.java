package com.pluralsight.serialization;

import java.io.*;

class Dog implements Serializable {

    String name;
    String breed;

    public Dog(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }
}

class Main {
    public static void main(String[] args) {

        Dog dog1 = new Dog("Tyson", "Labrador");  // Creates an object of Dog class

        try {
            String filename = "C:\\Kurser\\Java Core Platform\\serfile.txt";

            FileOutputStream fileOut = new FileOutputStream(filename);  // File for object stream
            ObjectOutputStream objOut = new ObjectOutputStream(fileOut); // Creates an ObjectOutputStream
            objOut.writeObject(dog1);  // Writes objects to the output stream

            FileInputStream fileIn = new FileInputStream(filename);  // File for object stream
            ObjectInputStream objIn = new ObjectInputStream(fileIn);  // Creates an ObjectInputStream
            Dog newDog = (Dog) objIn.readObject();  // Reads the object

            System.out.println("Dog Name: " + newDog.name);   System.out.println("Dog Breed: " + newDog.breed);

            objOut.close();         objIn.close();  //clean up
        }

        catch (Exception e) {
            e.getStackTrace();
        }
    }
}