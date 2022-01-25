package java_fundamentals.core_platform.input_and_output_with_streams;

import java.io.IOException;

/**
 * Created by Jim on 1/9/2016.
 */
public class MyAutoCloseable implements AutoCloseable {
    public void saySomething() throws IOException{
        throw new IOException("Exception from saySomething");
//        System.out.println("Something");
    }
    @Override
    public void close() throws IOException {
        throw new IOException("Exception from close");
//        System.out.println("close");
    }
}
