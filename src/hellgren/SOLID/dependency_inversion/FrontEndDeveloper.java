package hellgren.SOLID.dependency_inversion;

import hellgren.SOLID.dependency_inversion.Developer;

public class FrontEndDeveloper implements Developer {

    String name;

    public FrontEndDeveloper(String name) {
        this.name = name;
    }

    @Override
    public void develop() {
        writeJavascript();
    }

    public void writeJavascript() {
        System.out.println(name+" develops Java script");
    }

}
