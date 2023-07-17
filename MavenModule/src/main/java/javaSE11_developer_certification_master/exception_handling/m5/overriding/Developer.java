package javaSE11_developer_certification_master.exception_handling.m5.overriding;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Developer extends TeamMember {

    // CANNOT add a checked exception without breaking
    @Override
    public void work() {
        System.out.println("Dev");
    }
}
