package medium.abstract_factory;

// OnePlusFactory
public class OnePlusFactory implements IMobileComponentFactory{

    public OnePlusFactory(){
        System.out.println("🎉 Manufacturing OnePlus 🎉");
    }

    @Override
    public ICamera createCamera() {
        return new OnePlusCamera();
    }

    @Override
    public IDisplay createDisplay() {
        return new OnePlusDisplay();
    }

    @Override
    public String createName() {
        return "android";
    }
}