package hellgren.lombok;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.flogger.Flogger;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;

@Log
//@Log4j
public class TestCleanUpReader {

    String file="src/resources/blinka.txt";

    @SneakyThrows
    @Test
    public void printBlinka() {

        @Cleanup  //ensure resource is cleanup up after use
        BufferedReader br=new BufferedReader(new FileReader(file));

        String s = null;
        while ((s=br.readLine())!=null)
        {
            System.out.println(s);
        }

    }


    @SneakyThrows
    @Test
    public void logBlinka() {

        @Cleanup  //ensure resource is cleanup up after use
        BufferedReader br=new BufferedReader(new FileReader(file));

        String s = null;
        while ((s=br.readLine())!=null)
        {
        log.info(s);
        }

    }

}
