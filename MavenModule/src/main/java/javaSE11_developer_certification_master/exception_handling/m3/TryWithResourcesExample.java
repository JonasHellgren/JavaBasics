package javaSE11_developer_certification_master.exception_handling.m3;

import java.io.*;

public class TryWithResourcesExample {

    public static void main(String[] args) throws IOException {

        try (FileInputStream in = new FileInputStream("src/main/resources/in.txt");
                FileOutputStream out = new FileOutputStream("src/main/resources/out.txt")) {
            out.write(in.readAllBytes());
        }


    }
}
