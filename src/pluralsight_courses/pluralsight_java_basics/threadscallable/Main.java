package pluralsight_courses.pluralsight_java_basics.threadscallable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    static String[] inFiles={"infile1.txt","infile2.txt","infile3.txt","infile4.txt"};
    static String[] outFiles={"outfile1.txt","outfile2.txt","outfile3.txt","outfile4.txt"};

    public static void main(String[] args) throws Exception {

        //thread example saving results on files
        //------------------------------------------
        Thread[] threads = new Thread[inFiles.length];  //create array container of threads

        for (int i=0; i<inFiles.length;i++) {
            FileAdder adder = new FileAdder(inFiles[i], outFiles[i]);  //creat runnable object adder
            threads[i] = new Thread(adder);    threads[i].start();
        }
        for (Thread thread:threads)  thread.join();   //wait for thread completion

        //thread example letting threads return results to main method
        //returned results also affect a static/common variable in CallableAdder: totsum
        //----------------------------------------------------------------------------
        ExecutorService es= Executors.newFixedThreadPool(3);  //create container for thread pool
        Future<Integer>[] results = new Future[inFiles.length]; //threads will return results to variable results
        for (int i=0; i < inFiles.length; i++) {
            CallableAdder adder = new CallableAdder(inFiles[i]); //create thread
            results[i]=es.submit(adder); //put thread into pool and start it, future results in result variable
        }

        for (Future<Integer> result:results) {
            try { int value=result.get(); System.out.println("sum:" +value); }  //waits until return values available
            catch(ExecutionException e)   //relevant if some thread problem
                { System.out.println(e.getClass().getSimpleName() + " = " + e.getMessage()); }
            }

        es.shutdown();  //threads in the pool are finihsed with previous works, now waiting for other jobs
        // need to shutdown pool to terminate.

        System.out.println("Total sum:" + CallableAdder.GetTotsum());
    }
}
