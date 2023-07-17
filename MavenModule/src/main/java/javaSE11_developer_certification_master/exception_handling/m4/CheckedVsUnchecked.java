package javaSE11_developer_certification_master.exception_handling.m4;

import java.io.IOException;
import java.nio.file.Files;

public class CheckedVsUnchecked {

    public static void main(String[] args) {
        doThis();  //compiles, exception does not to be checked
       // doThat();  //wont compile, exception needs to be checked
        System.out.println("This will not run");
    }

    private static void doThat() throws IOException {
        throw new IOException();
    }

    private static void doThis() throws IllegalArgumentException {
        throw new IllegalArgumentException();
    }
}
