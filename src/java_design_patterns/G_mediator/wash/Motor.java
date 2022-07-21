package java_design_patterns.G_mediator.wash;

public class Motor extends PartAbstract {


    public void startMotor(){
        System.out.println("Motor is on...");
    }

    public void rotateDrum(int speed){
        System.out.println("Rotating at speed =  "+speed);
    }

}
