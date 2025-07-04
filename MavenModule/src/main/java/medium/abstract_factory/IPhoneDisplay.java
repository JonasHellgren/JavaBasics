package medium.abstract_factory;

// IPhoneDisplay
public class IPhoneDisplay implements IDisplay {

    @Override
    public void displaySettings(int fps) {
        switch (fps){
            case 30 -> System.out.println("Display changed to 30 FPS");
            case 60 -> System.out.println("Display changed to 60 FPS");
            default -> System.out.println("IPhone currently doesn't support " + fps + " FPS");
        }
    }
}