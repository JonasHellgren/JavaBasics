package com.pluralsight.threadscallable;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

public class CallableAdder implements Callable<Integer> {  //this class can be used as thread thanks to interface Runnable
    private String in, out;  //in file name
    private Path filein;
    private static int totsum;   //sum of alla sums
    public CallableAdder(String in) { this.in=in; this.totsum=0;  //constructor
        filein = Paths.get("C:\\Kurser\\Java Core Platform\\"+in);
    }
    private int doAdd() throws IOException {
        int sum=0;
        try (BufferedReader br = Files.newBufferedReader(filein, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {  sum=sum+Integer.parseInt(line);   }
        }
        IncTotsum(sum);        return sum;
    }
    //synchronized => only one thread can call function at specific time. To avoid memory access conflicts.
    private synchronized void IncTotsum(int sum) {totsum=totsum+sum;}
    public static int GetTotsum() {return totsum; }
    @Override
    public Integer call() throws IOException {  //this will happen when thread is started
        return doAdd();
    }
}
