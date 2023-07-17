package javaSE11_developer_certification_master.exception_handling.m3;

import java.io.IOException;

public class MyResource implements AutoCloseable {

    String name;

    public MyResource(String name) {
        this.name = name;
    }

    @Override
    public void close() {
        System.out.println("Closing resource #: " + name);
    }
}
