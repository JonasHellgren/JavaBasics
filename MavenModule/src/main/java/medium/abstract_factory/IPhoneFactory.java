package medium.abstract_factory;

// IPhoneFactory
public class IPhoneFactory implements IMobileComponentFactory {

    public IPhoneFactory(){
        System.out.println("🎉 Manufacturing IPhone 🎉");
    }

    @Override
    public ICamera createCamera() {
        return new IPhoneCamera();
    }

    @Override
    public IDisplay createDisplay() {
        return new IPhoneDisplay();
    }

    @Override
    public String createName() {
        return "ios";
    }
}