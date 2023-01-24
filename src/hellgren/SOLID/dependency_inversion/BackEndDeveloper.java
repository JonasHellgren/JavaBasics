package hellgren.SOLID.dependency_inversion;


public class BackEndDeveloper implements Developer {

    String name;

    public BackEndDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void develop() {
        writeJava();
    }

    private void writeJava() {
        System.out.println(name+" develops Java");
    }

}
