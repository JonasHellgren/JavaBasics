package javaSE11_developer_certification_master.exception_handling.m5.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Child extends Parent {

    @Override
    void doThing() throws
            FileNotFoundException,
            IOException
//            Exception
    {
    }

}
