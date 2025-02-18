package medium.abstract_factory;

// IMobileComponentFactory
public interface IMobileComponentFactory {
    ICamera createCamera();
    IDisplay createDisplay();
    String createName();
}