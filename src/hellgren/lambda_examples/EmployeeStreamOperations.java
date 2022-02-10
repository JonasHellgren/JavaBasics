package hellgren.lambda_examples;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.swing.text.Position;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeStreamOperations {

    public enum Position {DEV, DEV_OPS, QA};

    @Getter
    @Setter
    @ToString
    public static class Employee {
        private String firstName;
        private String lastName;
        private Position position;
        private List<String> skills;
        private int salary;

        public Employee() {
        }

        public Employee(String firstName, String lastName,
                        Position position, int salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.position = position;
            this.salary = salary;
        }

        public void setSkills(String... skills) {
            this.skills = Arrays.stream(skills).collect(Collectors.toList());
        }

        public String getName() {
            return this.firstName + " " + this.lastName;
        }
    }

    private static List<Employee> createCompany() {
        Employee dev1 = new Employee("John", "Doe", Position.DEV, 110);
        dev1.setSkills("C#", "ASP.NET", "React", "AngularJS");
        Employee dev2 = new Employee("Peter", "Doe", Position.DEV, 120);
        dev2.setSkills("Java", "MongoDB", "Dropwizard", "Chef");
        Employee dev3 = new Employee("John", "Smith", Position.DEV, 115);
        dev3.setSkills("Java", "JSP", "GlassFish", "MySql");
        Employee dev4 = new Employee("Brad", "Johston", Position.DEV, 100);
        dev4.setSkills("C#", "MSSQL", "Entity Framework");
        Employee dev5 = new Employee("Philip", "Branson", Position.DEV, 140);
        dev5.setSkills("JavaScript", "React", "AngularJS", "NodeJS");
        Employee dev6 = new Employee("Nathaniel", "Barth", Position.DEV, 99);
        dev6.setSkills("Java", "Dropwizard");
        Employee qa1 = new Employee("Ronald", "Wynn", Position.QA, 100);
        qa1.setSkills("Selenium", "C#", "Java");
        Employee qa2 = new Employee("Erich", "Kohn", Position.QA, 105);
        qa2.setSkills("Selenium", "JavaScript", "Protractor");
        Employee devOps1 = new Employee("Harold", "Jess", Position.DEV_OPS, 116);
        devOps1.setSkills("CentOS", "bash", "c", "puppet", "chef", "Ansible");
        Employee devOps2 = new Employee("Karl", "Madsen", Position.DEV_OPS, 123);
        devOps2.setSkills("Ubuntu", "bash", "Python", "chef");

        return Arrays.asList(dev1, dev2, dev3, dev4, dev5, dev6,
                qa1, qa2, devOps1, devOps2);
    }

    /***
     *
     This method accepts none, one or many positions. If no positions are provided then information for all positions is printed.
     Positions array is transferred to List<String> because all objects used in lambda should be effectively final.
     Transferring array to stream is done with Arrays.stream() method. Employees are filtered based on the desired position.
     Each skills list is concatenated and flattened to a stream with flatMap(). After this operation, there is a stream of
     strings with all skills. Duplicates are removed with distinct(). Finally, stream is collected to a list.
     */
    public static List<String> gatherEmployeeSkills(
            List<Employee> employees, Position... positions) {
        positions = positions == null || positions.length == 0
                ? Position.values() : positions;
        List<Position> searchPositions = Arrays.stream(positions)
                .collect(Collectors.toList());
        return employees == null ? Collections.emptyList()
                : employees.stream()
                .filter(employee
                        -> searchPositions.contains(employee.getPosition()))
                .flatMap(employee -> employee.getSkills().stream())  //join many streams
                .distinct()
                .collect(Collectors.toList());
    }

    /***
     *
     This method first received a list of all skills per position and converts it to a stream. The stream can be
     collected to a String with Collectors.joining() method. It accepts delimiter, prefix, and suffix.
     */

    public static String printEmployeeSkills(
            List<Employee> employees, Position position) {
        List<String> skills = gatherEmployeeSkills(employees, position);
        return skills.stream()
                .collect(Collectors.joining("; ",
                        "Our " + position + "s have: ", " skills"));
    }

    /***
     This method returns Map with Position as key and IntSummaryStatistics as value. Collectors.groupingBy() groups
     employees by position key and then using Collectors.summarizingInt() to get statistics of employee’s salary.
     */

    public static Map<Position, IntSummaryStatistics> salaryStatistics(
            List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.summarizingInt(Employee::getSalary)));
    }

    /***
     Map with position and salary summary is retrieved and then with entrySet().stream() map is converted to stream of
     Entry<Position, IntSummaryStatistics> objects. Entries are sorted by average value in ascending order by custom
     comparator Double.compare(). findFirst() returns Optional<Entry>. The entry itself is obtained with get() method. T
     he key which is basically the position is obtained with getKey() method.
     */

    public static Position positionWithLowestAverageSalary(
            List<Employee> employees) {
        return salaryStatistics(employees)
                .entrySet().stream()
                .sorted(Comparator.comparingDouble(entry -> entry.getValue().getAverage()))
                .findFirst()
                .get()
                .getKey();
    }

    /**
     Grouping is done per position and employees are aggregated to list with Collectors.toList() method.
     */

    public static Map<Position, List<Employee>> employeesPerPosition(
            List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(e -> e.getPosition(),
                        Collectors.toList()));
    }

    /**
     *
     Similar to the method above, but one more mapping is needed here. Employee name should be extracted and converted
     to List<String>. This is done with Collectors.mapping(Employee::getName, Collectors.toList()) method.
     */

    public static Map<Position, List<String>> employeeNamesPerPosition(
            List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.mapping(Employee::getName,
                                Collectors.toList())));
    }

    /**
     * Getting the count is done by Collectors.counting() method. It returns Long by default. If Integer is needed
     * then this can be changed to Collectors.reducing(0, e -> 1, Integer::sum).
     */

    public static Map<Position, Long> employeesCountPerPosition(
            List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.counting()));
    }

    public static void main(String[] args) {

        List<Employee> employeeList = createCompany();

        employeeList.forEach(e -> System.out.println(e));

        List<String> employeeSkillsList = gatherEmployeeSkills(employeeList, Position.DEV, Position.QA);
        System.out.println("employeeSkillsList = " + employeeSkillsList);

        System.out.println("printEmployeeSkills(employeeList, Position.DEV) = " + printEmployeeSkills(employeeList, Position.DEV));

        Map<Position, IntSummaryStatistics> salaryStatMap=salaryStatistics(employeeList);
        System.out.println("salaryStatMap = " + salaryStatMap);

        System.out.println("positionWithLowestAverageSalary = " + positionWithLowestAverageSalary(employeeList));

        Map<Position, List<Employee>> empPosMap=employeesPerPosition(employeeList);
        System.out.println("empPosMap = " + empPosMap);

        Map<Position, List<String>> empPerPosMap=employeeNamesPerPosition(employeeList);
        System.out.println("empPerPosMap = " + empPerPosMap);

        Map<Position, Long> employeesCountPerPositionMap= employeesCountPerPosition(employeeList);
        System.out.println("employeesCountPerPositionMap = " + employeesCountPerPositionMap);


    }

}
