package apache.systemutils;

import org.junit.Test;
import org.apache.commons.lang3.*;

public class SystemUtilsTest {

    public static void main(String[] args) {
        System.out.println("SystemUtils.getUserDir() = " + SystemUtils.getUserDir());
        System.out.println("SystemUtils.getUserHome() = " + SystemUtils.getUserHome());
        System.out.println("SystemUtils.getUserName() = " + SystemUtils.getUserName());
        // Get the Java version
        String javaVersion = SystemUtils.JAVA_VERSION;
        System.out.println("Java Version: " + javaVersion);

        // Check if the OS is Windows
        boolean isWindows = SystemUtils.IS_OS_WINDOWS;
        System.out.println("Is Windows: " + isWindows);

    }
}
