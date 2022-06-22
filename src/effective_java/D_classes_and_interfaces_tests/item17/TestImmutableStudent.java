package effective_java.D_classes_and_interfaces_tests.item17;

import effective_java.D_classes_and_interfaces.item17.ImmutableStudent;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestImmutableStudent {

    public static final String DYMMY_NAME = "Arne";
    public static final int REG_NO = 3523235;

    @Test
    public void testChangeName() {

        ImmutableStudent immutableStudent = createStudent();
        System.out.println("immutableStudent = " + immutableStudent);

        String name=immutableStudent.getName();
        name= DYMMY_NAME;
        Assert.assertNotEquals(DYMMY_NAME,immutableStudent.getName());
    }

    @Test
    public void testChangeRegNo() {

        ImmutableStudent immutableStudent = createStudent();
        System.out.println("immutableStudent = " + immutableStudent);

        int regNo=immutableStudent.getRegNo();
        regNo= REG_NO;
        Assert.assertNotEquals(REG_NO,immutableStudent.getRegNo());
    }

    private ImmutableStudent createStudent() {
        Map<String, String> metadata=new HashMap<>();
        metadata.put("mamma","Margit");
        ImmutableStudent immutableStudent = new ImmutableStudent("Jonas", 353224,metadata);
        return immutableStudent;
    }

}
