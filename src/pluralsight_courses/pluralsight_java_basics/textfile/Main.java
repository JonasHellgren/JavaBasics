package pluralsight_courses.pluralsight_java_basics.textfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Version 1");    printfilever1();
        System.out.println("Version 2");    printfilever2();
        System.out.println("Version 3");    printfilever3();
    }

    public static void printfilever1() throws IOException {  //A static method belongs to the class rather than the object of a class.

        File file = new File("C:\\kurser\\Java Core Platform\\datamanylines.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        char[] buff = new char[8];
        int length;
        try {
            while ((length = br.read(buff)) >= 0) {
                System.out.print("\nlength:" + length);
                for (int i = 0; i < length; i++)
                    System.out.print(buff[i]);
            }
        //following statements is to handle exceptions
        } catch (IOException e) {   //probably due to file.txt not found
            System.out.print(e.getClass().getSimpleName() + " = " + e.getMessage());
        } finally {    //clean up statements
            try {
                if (br != null)
                    br.close();
            } catch (IOException e2) {   //failed to close
                System.out.print(e2.getClass().getSimpleName() + " = " + e2.getMessage());
            }
        }
    }

    public static void printfilever2() throws IOException {  //A static method belongs to the class rather than the object of a class.
        //This version does not need clean up statements after finally, inbuilt due to try(Bufferreader..)
        Path filepath = Paths.get("C:\\Kurser\\Java Core Platform\\datamanylines.txt");
        //System.out.print(filepath);
        try (BufferedReader br = Files.newBufferedReader(filepath, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (IOException  e)
        { System.out.print(e.getClass().getSimpleName() + " = " + e.getMessage());}
    }

    public static void printfilever3() throws IOException {  //A static method belongs to the class rather than the object of a class.
        //This version uses readAllLines
        Path filepath = Paths.get("C:\\Kurser\\Java Core Platform\\datamanylines.txt");

        List<String> lines = Files.readAllLines(filepath);
        for (String line:lines)
            System.out.println(line);
       }
}
