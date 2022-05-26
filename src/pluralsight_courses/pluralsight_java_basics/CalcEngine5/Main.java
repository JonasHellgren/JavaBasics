package pluralsight_courses.pluralsight_java_basics.CalcEngine5;

public class Main {

    public static void main(String[] args) {
        String[] statements = {
                "add 100.0 50.0",  //100+50=150
                "power 5.0 2"    //5^2=25
        };

        //construct smart helper that can process multiple types of math command statements
        DynamicHelper helper = new DynamicHelper(new MathProcessing[]
                {new Adder(),
                 new PowerOf()
                });

        for (String statement:statements) {
            String output = helper.process(statement);     System.out.println(output);
        }

	    }
}
