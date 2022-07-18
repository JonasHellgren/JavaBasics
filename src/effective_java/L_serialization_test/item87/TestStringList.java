package effective_java.L_serialization_test.item87;

import effective_java.L_serialization.example.SerializableClass;
import effective_java.L_serialization.item87.StringList;
import org.junit.Assert;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestStringList {

    public static final String FILE = "src/effective_java/L_serialization_test/examples/file2.txt";

    @Test
    public void testCreateList() {

        StringList stringList=new StringList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");

        System.out.println(stringList.getData());
    }

    @Test
    public void test() {

        StringList stringList = new StringList();
        stringList.add("1");
        stringList.add("2");
        stringList.add("3");
        System.out.println(stringList.getData());

        List<String> stringListFromSerialization = new ArrayList<>();
        doSerialization(stringList, FILE);
        try {
            StringList deSerObject = doDeserialization(FILE);
            System.out.println("Object has been deserialized ");
            stringListFromSerialization=deSerObject.getData();
            System.out.println("stringListFromSerialization = " + stringListFromSerialization);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }

        System.out.println("Test finished");

        Assert.assertTrue(stringListFromSerialization.contains("1"));

    }

    private void doSerialization(StringList object, String filename) {
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            // Method for serialization of object
            out.writeObject(object);
            out.close();
            file.close();
            System.out.println("Object has been serialized");
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    private StringList doDeserialization(String filename) throws IOException, ClassNotFoundException {
        // Reading the object from a file
        FileInputStream file = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(file);
        StringList object1 = (StringList) in.readObject();  // Method for deserialization of object
        in.close();
        file.close();
        return object1;
    }



}
