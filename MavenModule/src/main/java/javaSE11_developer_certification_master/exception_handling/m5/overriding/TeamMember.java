package javaSE11_developer_certification_master.exception_handling.m5.overriding;

import java.io.IOException;

public abstract class TeamMember {

    // can add a checked exception without breaking
    public void work() throws IOException  {
        System.out.println("TeamMember");
    }
}
