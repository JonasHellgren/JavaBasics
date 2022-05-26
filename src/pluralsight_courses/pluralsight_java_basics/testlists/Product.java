package pluralsight_courses.pluralsight_java_basics.testlists;

public class Product {
    private final String name;   //A final variable can only be initialized once
    private final int mass;      //in this case by constructor

    public Product(String name, int mass)  {this.name=name; this.mass=mass;}  //constructor

    public String getName() { return name;}     //method
    public int getMass() { return mass;}        //method

    @Override
    public String toString() {  return "Name="+getName()+", mass="+getMass();   }

    //@Override
    //public boolean equals(String name) {return (name.equalsIgnoreCase(getName()));}
}
