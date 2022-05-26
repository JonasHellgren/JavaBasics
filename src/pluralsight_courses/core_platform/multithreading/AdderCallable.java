package pluralsight_courses.core_platform.multithreading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Callable;

class AdderCallable implements Callable <Integer> {
    private String inFile, outFile;

    public AdderCallable(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    @Override
    public Integer call() {
        int total = 0;
        try {
            total=doAdd();
        } catch(IOException e) {
            System.out.println("IOException");
        }
        return total;
    }

    public Integer doAdd() throws IOException {
        int total = 0;
        String line = null;
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inFile))) {
            while ((line = reader.readLine()) != null)
                total += Integer.parseInt(line);
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(outFile))) {
            writer.write("Total: " + total);
        }
        return total;
    }
}