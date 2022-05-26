package pluralsight_courses.pluralsight_java_basics.innerclass;

public class Main {

    public static void main(String[] args) {
        Computer computer1 = new Computer("i3");
        Computer.Processor processor1 = computer1.new Processor();  // create an object of inner class using outer class
        //processor.SetFlops();   //un-comment if no processor constructor calling method
        System.out.println(computer1.getName()+", has following flops:"+processor1.getFlops());

        Computer computer2 = new Computer("i5");
        Computer.Processor processor2 = computer2.new Processor();  // create an object of inner class using outer class
        System.out.println(computer2.getName()+", has following flops:"+processor2.getFlops());
    }
}
