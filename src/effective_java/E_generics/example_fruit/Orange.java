package effective_java.E_generics.example_fruit;

public class Orange implements FruitInterface<OrangeProperties> {

    OrangeProperties orangeProperties;

    public Orange(OrangeProperties orangeProperties) {
        this.orangeProperties = orangeProperties;
    }

    @Override
    public OrangeProperties getProperties() {
        return orangeProperties;
    }

    @Override
    public void showProperties() {
        System.out.println("The orange diameter = "+orangeProperties.diameter);
    }

}
