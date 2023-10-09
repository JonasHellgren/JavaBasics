package mobilapp_java_receipes.files;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Date;

public class TestFiles {

    public static final String FILE_TXT = "data_copy/file.txt";
    public static final String FILE_ROOT = "src/mobilapp_java_receipes/files/data_copy/file.txt";

    @Test
    public void givenFile_whenExist() {
        var file = Paths.get(FILE_TXT);
        var exists = Files.exists(file);
        Assert.assertTrue(exists);
    }

    @Test
    public void givenFile_whenNotExist() {
        var file = Paths.get("data_copy/fileNotExisting.txt");
        var exists = Files.exists(file);
        Assert.assertFalse(exists);
    }

    @Test
    public void whenFileProperties_thenCorrect() {

        var filePath = FILE_TXT;
        var file = new File(FILE_ROOT);
        //var file = Paths.get(FILE_TXT);

//file size (the second method)
        var fileSize = file.length();

//file modification date
        var dateChanges = new Date(file.lastModified());

//file creation date
        var creationDate = FileTime.fromMillis(0);
        try {
            var attr = Files.readAttributes(
                    file.toPath(), BasicFileAttributes.class);
            creationDate = attr.creationTime();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

//is readable file
        var isReadable = file.canRead();

//is writable file
        var isWritable = file.canWrite();

        var pos = filePath.lastIndexOf('.');
//file extension
        var extension = "";
        if (pos > 0) {
            extension = filePath.substring(pos + 1);
        }

//file directory
        var fileDir = file.getParent();

        System.out.println("fileSize is " + fileSize);
        System.out.println("dateChanges is "+ dateChanges);
        System.out.println("creationDate is "+ creationDate);
        System.out.println("isReadable is " + isReadable);
        System.out.println("isWritable is " + isWritable);
        System.out.println("extension is " + extension);
        System.out.println("fileDir is " + fileDir);

        Assert.assertTrue(isReadable);
        Assert.assertEquals("txt",extension);


    }

}
