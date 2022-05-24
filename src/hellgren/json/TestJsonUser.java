package hellgren.json;

import org.junit.Before;
import org.junit.Test;


import java.io.FileWriter;

public class TestJsonUser {

    String filePath="src/resources";
    //Gson gson;

    @Before
    public void init() {
   //     Gson gson = new Gson();
    }

    @Test
    public void testSaveUser() {
        User user = new User(1, "Tom Smith", "American");
     //   gson.toJson(user, new FileWriter(filePath));
    }

}
