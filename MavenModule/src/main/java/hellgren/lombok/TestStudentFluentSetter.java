package hellgren.lombok;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class TestStudentFluentSetter {

    StudentFluentSetter student;

    @Before
    public void init() {
        student=new StudentFluentSetter("Jonas").lastName("Hellgren").year(1993);
    }

    @Test
    public void given_thenCorrect() {
        Assert.assertEquals("Hellgren",student.lastName());
        Assert.assertTrue(student.marks().isEmpty());
    }

    @Test
    public void given_whenMarks_thenCorrect() {
        student=new StudentFluentSetter("Jonas").marks(List.of(5,5,5));
        Assert.assertEquals("Jonas",student.firstName());
        Assert.assertEquals("",student.lastName());
        Assert.assertFalse(student.marks().isEmpty());
    }

}
