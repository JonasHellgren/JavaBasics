package medium.properties_via_static_block;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    static String PATH="MavenModule/src/main/resources/";
    static String FILE="config.properties";

    static Properties config;

    static {
        // Example: Load configuration from a file
        try (InputStream input = new FileInputStream(PATH+FILE)) {
            config = new Properties();
            config.load(input);
        } catch (IOException e) {
            // Handle file loading exception
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return config.getProperty(key);
    }
}
