package pluralsight_new_in_java17.logging;

import lombok.extern.java.Log;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

@Log
public class TestLogging {

    static {
        // must set before the Logger, loads logging.properties from the classpath
        try (InputStream is = TestLogging.class.getClassLoader().getResourceAsStream("logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void whenLogInfo_thenShow() {
        log.info("Info log");
    }


    @Test
    public void whenLogFine_thenNoShow() {
        log.fine("Fine log will not be shown");
    }
}
