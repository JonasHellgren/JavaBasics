package pluralsight_courses.pluralsight_java_basics.threadscallable;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileAdder implements Runnable {  //this class can be used as thread thanks to interface Runnable
    private String in, out;  //in and out file.txt names
    private Path filein, fileout;  //file.txt names with path
    public FileAdder(String in, String out) { this.in=in; this.out=out;  //constructor
         filein = Paths.get("C:\\Kurser\\Java Core Platform\\"+in);
         fileout = Paths.get("C:\\Kurser\\Java Core Platform\\"+out);
    }
    private void doAdd() throws IOException {
        int sum=0;
        try (BufferedReader br = Files.newBufferedReader(filein, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {  sum=sum+Integer.parseInt(line);   }
            System.out.println("Sum of file.txt " + in + " is " + sum + ". The sum is saved to file.txt " + out);
            SaveSum(fileout, sum);  //save sum result in file.txt
        }
        catch (IOException  e)
        { System.out.println(e.getClass().getSimpleName() + " = " + e.getMessage());     }
        finally {  } //executed whether exception occurs or not
    }
    private void SaveSum(Path fileout, int sum) {  //This function saves sum into file.txt fileout
        try (BufferedWriter bw = Files.newBufferedWriter(fileout)) {  bw.write(String.valueOf(sum));   }
        catch (IOException  e)
        { System.out.println(e.getClass().getSimpleName() + " = " + e.getMessage());      }
    }
    @Override
    public void run() {  //this will happen when thread is started
        try {doAdd();  }
        catch (IOException ex) {  System.out.println(ex.getClass().getSimpleName() + " = " + ex.getMessage());       }
    }
}
