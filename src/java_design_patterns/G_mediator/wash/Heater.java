package java_design_patterns.G_mediator.wash;

public class Heater extends PartAbstract {
    public void on(int temp){
        System.out.println("Heater is on...");
        if(mediator.checkTemperature(temp)){
            System.out.println("Temperature is set to "+temp);
            mediator.off();
        }
    }

    public void off(){
        System.out.println("Heater is off...");
        mediator.wash();
    }
}
