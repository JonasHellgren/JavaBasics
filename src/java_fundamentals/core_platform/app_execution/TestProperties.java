package java_fundamentals.core_platform.app_execution;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class TestProperties {
    public static void main(String[] args) {
        try {
            Properties defaultProps = new Properties();
            loadDefaultProps(defaultProps);
            System.out.println("defaultProps = " + defaultProps);

            Properties userProps = new Properties(defaultProps);
            loadUserProps(userProps);

            String welcomeMessage = userProps.getProperty("welcomeMessage");
            String farewellMessage = userProps.getProperty("farewellMessage");

            System.out.println(welcomeMessage);
            System.out.println(farewellMessage);

            if(userProps.getProperty("isFirstRun").equalsIgnoreCase("Y")) {
                userProps.setProperty("welcomeMessage", "Welcome back");
                userProps.setProperty("farewellMessage", "Things will be familiar now");
                userProps.setProperty("isFirstRun", "N");
                saveUserProps(userProps);
            }

        } catch (IOException e) {
            System.out.println("Exception <" + e.getClass().getSimpleName() + "> " + e.getMessage());
        }
    }

    private static void loadDefaultProps(Properties defaultProps) throws IOException {
        Path userFile = Paths.get("src/java_fundamentals/core_platform/app_execution/MyDefaultValues.xml");
        if (Files.exists(userFile)) {
            try (InputStream inputStream = Files.newInputStream(userFile)) {
                defaultProps.loadFromXML(inputStream);
            }
        }
    }

    private static Properties loadUserProps(Properties userProps) throws IOException{
        Path userFile = Paths.get("src/java_fundamentals/core_platform/app_execution/userValues.xml");
        if(Files.exists(userFile)) {
            try(InputStream inputStream = Files.newInputStream(userFile)) {
                userProps.loadFromXML(inputStream);
            }
        }

        return userProps;
    }

    private static void saveUserProps(Properties userProps) throws IOException {
        try(OutputStream outputStream = Files.newOutputStream(Paths.get("userValues.xml"))) {
            userProps.storeToXML(outputStream, null);
        }
    }
}

