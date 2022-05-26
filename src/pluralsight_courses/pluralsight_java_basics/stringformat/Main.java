package pluralsight_courses.pluralsight_java_basics.stringformat;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.StringJoiner;

public class Main {

    public static void main(String[] args) throws IOException {

        String joe = String.format("%s = %d", "joe", 35);
        String jim = String.format("%s = %d", "jim", 33);
        StringJoiner output = new StringJoiner(",", "[", "]");
        output.add(joe);  output.add(jim);
        System.out.println(output.toString());   //-> [joe = 35,jim = 33]

        StringBuilder sbuf = new StringBuilder();
        Formatter fmt = new Formatter(sbuf);  //convert sbuf into fmt so can perform formatting operations
        fmt.format("PI = %f%n", Math.PI);   //f=decimal number, N=Platform-specific line separator
        System.out.print(sbuf.toString());   //-> PI = 3,141593

        Integer intnum=93;  String numtxt=String.format("|%-20d|", intnum);
        System.out.println(numtxt);   // -> |93                  |

        Double fnum=2.00023;
        DecimalFormat df = new DecimalFormat("#.##");  //any number, integer, float or double.
        String formatted = df.format(fnum);
        System.out.println(formatted); //->  2

        String strDouble = String.format("%.2f", fnum);  //will always print trailing zeros
        System.out.println(strDouble); // -> 2.00

        //Following code creates file with two lines
        Path filepath = Paths.get("C:\\Kurser\\Java Core Platform\\created.txt");  //define file for writing
        Integer alex=1, christofer=17;  //ages of sone
        BufferedWriter writer = Files.newBufferedWriter(filepath);  //file writing object
        try (Formatter f = new Formatter(writer)) {  //wrap formatter clas on writer
            f.format("My sons are %d and %d years old%n", alex,christofer);
            Double avgage=(double)(alex+christofer)/2;
            f.format("Average age is %.1f years", avgage);
        }        //no catch in main
    }
}
