package java_design_patterns.G_mediator.wash.help_classes;

public class Sensor {

    public boolean checkTemperature(int temp){
        System.out.println("Temperature reached "+temp+" C");
        return true;
    }

}
