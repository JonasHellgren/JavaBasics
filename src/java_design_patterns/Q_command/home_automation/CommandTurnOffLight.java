package java_design_patterns.Q_command.home_automation;

public class CommandTurnOffLight implements CommandInterface {
    Light light;

    public CommandTurnOffLight(Light light) {
        super();
        this.light = light;
    }

    public void execute() {
        System.out.println("Turning off light in"+light.getLocation());
        light.turnOff();
    }
}
