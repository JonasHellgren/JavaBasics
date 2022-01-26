package java_fundamentals.core_platform.multithreading;

import java.io.IOException;

public class TestAdder {

    public static void main(String[] args) {

        String path="src/java_fundamentals/core_platform/multithreading/";
        String[] inFiles= {path+"file1.txt",path+"file2.txt"};
        String[] outFiles= {path+"out1.txt",path+"out2.txt"};

        for(int i=0; i < inFiles.length; i++) {
            System.out.println("inFiles[i] = " + inFiles[i]);
            System.out.println("outFiles[i] = " + outFiles[i]);
        }


        try {
            for(int i=0; i < inFiles.length; i++) {
                Adder adder= new Adder(inFiles[i], outFiles[i]);
                adder.doAdd();
            }
        } catch(IOException e) {
            System.out.println("File not found");
        }

    }
}
