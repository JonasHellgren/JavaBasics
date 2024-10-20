package medium.properties;

import lombok.NonNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * https://medium.com/@sonaldwivedi/how-to-read-config-properties-file-in-java-6a501dc96b25
 */

public class ReadPropertyFile {

    public static void main(String[] args) throws IOException {
        Properties prop = getProperties("MavenModule/src/main/resources/","config.properties");

        System.out.println("prop = " + prop);
        var name=prop.getProperty("name");
        System.out.println("name = " + name);
        System.out.println("prop.size() = " + prop.size());
        System.out.println("prop.keySet() = " + prop.keySet());

    }

    private static @NonNull Properties getProperties(String path,String name) throws IOException {
        Properties prop=new Properties();
        FileInputStream ip= new FileInputStream(path+name);
        prop.load(ip);
        return prop;
    }

}
