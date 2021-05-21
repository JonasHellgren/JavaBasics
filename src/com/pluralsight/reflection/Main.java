package com.pluralsight.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        BankAccount ba=new BankAccount("Hellgren",0);

        Class thec, thesupc;   //create class objects
        thec=ba.getClass();  System.out.println(thec.getSimpleName());   //print class name
        thesupc=thec.getSuperclass();  System.out.println(thesupc.getSimpleName());  //print superclass name of class
        int modifiers=thec.getModifiers();   //get modifiers, for ex if final

        if (Modifier.isPublic(modifiers))   System.out.println("Class "+thec.getSimpleName()+" is public");
        Method[] methods=thec.getMethods();
        for (Method m:methods)
            if(m.getDeclaringClass()!=Object.class)   //exclude object class methods
                System.out.println(m.getName());  //print method name

        callDepositviareflection(ba,50);   //call method deposit via reflection
        System.out.println("New balance "+ba.getBalance());
    }

    static void callDepositviareflection(Object o, int a) {  //this funciton calls method deposit via reflection
        try{
            Class<?> thec=o.getClass();  //get class object of object o
            Method m=thec.getMethod("deposit",int.class);  //get access to method deposit
            m.invoke(o,a);  //call the method
        }  catch(Exception e) {System.out.println(e.getClass().getSimpleName() + " = " + e.getMessage());}
    }
}
