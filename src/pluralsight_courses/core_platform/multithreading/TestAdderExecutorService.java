package pluralsight_courses.core_platform.multithreading;

import lombok.SneakyThrows;

import java.util.concurrent.*;

public class TestAdderExecutorService {

    @SneakyThrows
    public static void main(String[] args) {

        String path="src/java_fundamentals/core_platform/multithreading/";
        String[] inFiles= {path+"file1.txt",path+"file2.txt"};
        String[] outFiles= {path+"out1.txt",path+"out2.txt"};


        for(int i=0; i < inFiles.length; i++) {
            System.out.println("inFiles[i] = " + inFiles[i]);
            System.out.println("outFiles[i] = " + outFiles[i]);
        }

        ExecutorService es =
                new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>());

        Future<Integer>[] results= new Future[inFiles.length];

        for(int i=0; i < inFiles.length; i++) {
            AdderCallable adder= new AdderCallable(inFiles[i], outFiles[i]);
            results[i] =  es.submit(adder);
        }

        //If the execution period is longer than specified (in this case, 200 milliseconds), a TimeoutException will be thrown.
        for(int i=0; i < inFiles.length; i++) {
            System.out.println("file1 results= " + results[i].get(200, TimeUnit.MILLISECONDS));
        }

        try {
            es.shutdown();
            es.awaitTermination(60, TimeUnit.SECONDS);
        } catch(Exception e) {
            System.out.println("ExecutorService exception");
        }

    }
}
