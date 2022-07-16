package effective_java.J_exceptions_tests.examples;

import effective_java.J_exceptions.examples.InvalidStatementException;
import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;

@Log
public class TestBufferReader {

    public static final String FILE_NOT_EXISTING = "dummy.txt";
    public static final String FILE = "src/effective_java/J_exceptions_tests/examples/file.txt";
    public static final String FILE_INVALID_LINE = "src/effective_java/J_exceptions_tests/examples/invalidLineFile.txt";

    boolean fileNotFound=false;
    boolean invalidLine=false;


    @Test
    public void readOkFile() {

       String file=FILE;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
          processFile(reader);

        } catch (FileNotFoundException ex) {
            log.warning("File not found + " + file);
            fileNotFound=true;
        } catch (InvalidStatementException ex) {
            log.warning("Invalid line statement");
           invalidLine=true;
        } catch (IOException ex) {
            log.warning("Error file.txt reading " + ex.getMessage());
        } catch (Exception ex) {
            log.warning("File error" + ex.getMessage());
        }

        Assert.assertFalse(fileNotFound);
        Assert.assertFalse(invalidLine);

    }

    @Test
    public void readNotExistingFile() {

        String file=FILE_NOT_EXISTING;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            processFile(reader);

        } catch (FileNotFoundException ex) {
            log.warning("File not found + " + file);
            fileNotFound=true;
        } catch (InvalidStatementException ex) {
            log.warning("Invalid line statement");
            invalidLine=true;
        } catch (IOException ex) {
            log.warning("Error file.txt reading " + ex.getMessage());
        } catch (Exception ex) {
            log.warning("File error" + ex.getMessage());
        }

        Assert.assertTrue(fileNotFound);

    }

    @Test
    public void readInvalidFile() {

        String file=FILE_INVALID_LINE;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            processFile(reader);

        } catch (FileNotFoundException ex) {
            log.warning("File not found + " + file);
            fileNotFound=true;
        } catch (InvalidStatementException ex) {
            log.warning("Invalid line statement");
            invalidLine=true;
        } catch (IOException ex) {
            log.warning("Error file.txt reading " + ex.getMessage());
        } catch (Exception ex) {
            log.warning("File error" + ex.getMessage());
        }

        Assert.assertTrue(invalidLine);

    }

    private static void processFile(BufferedReader reader) throws IOException, InvalidStatementException {

        String inputLine = null;
        while ((inputLine = reader.readLine()) != null) {
            performOper(inputLine);
        }
    }

    private static void performOper(String inputLine) throws InvalidStatementException {
        String[] parts = inputLine.split(" ");
        if (parts.length != 3) {
            throw new InvalidStatementException("Line must have three words");
        }

        System.out.println("inputLine = " + inputLine);

    }

}
