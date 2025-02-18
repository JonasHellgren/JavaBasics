package medium.abstract_factory;

// Mobile
public class Mobile {
    String name;
    private IDisplay display;
    private ICamera camera;

    private Mobile() {
    }

    public Mobile(IMobileComponentFactory mobileComponentFactory) {
        super();
        System.out.println();
        name = mobileComponentFactory.createName();
        display = mobileComponentFactory.createDisplay();
        camera = mobileComponentFactory.createCamera();
    }

    public void photo() {
        camera.captureImage();
    }

    public void video() {
        camera.recordVideo("1080");
    }

    public void video(String resolution) {
        camera.recordVideo(resolution);
    }

    public void setDisplay(){
        display.displaySettings(30);
    }

    public void setDisplay(int fps) {
        display.displaySettings(fps);
    }
}