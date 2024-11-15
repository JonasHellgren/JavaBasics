package hellgren.lombok;


import lombok.Data;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/***
 * A nice builder alternative
 *
 * https://medium.com/javarevisited/you-might-stop-using-lomboks-builder-after-reading-this-9139c22e75a7
 *
 *  Following clumpsy code is needed for builder
 *  @Builder(builderMethodName = "internalBuilder")
 * 	private Student(String firstName, String lastName, List<Integer> marks, Integer year) {
 * 		this.firstName = firstName;
 * 		this.lastName = lastName;
 * 		this.marks = marks;
 * 		this.year = year;
 * 		//generate some value based on other fields
 * 		this.studentId = generateStudentId(firstName);
 *    }
 *
 */

@Data
@Accessors(chain = true, fluent = true)
public class StudentFluentSetter {
    public static final ArrayList<Integer> MARKS = new ArrayList<>();
    public static final String EMPTY = "";
    private String firstName;
    private String lastName= EMPTY;
    private String studentId;
    private Integer year;
    private List<Integer> marks;

    public StudentFluentSetter(@NonNull String firstName) {
        this.firstName = firstName;
        this.studentId = generateStudentId(firstName);
        this.marks= MARKS;
    }

    private String generateStudentId(String firstName) {
        return firstName + new Random().nextInt(1000);
    }
}
