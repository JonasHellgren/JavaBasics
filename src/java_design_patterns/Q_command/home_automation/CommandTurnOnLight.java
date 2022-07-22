package java_design_patterns.Q_command.home_automation;

public class CommandTurnOnLight implements CommandInterface {
    Light light;

    public CommandTurnOnLight(Light light) {
        super();
        this.light = light;
    }

    public void execute() {
        System.out.println("Turning on light in "+light.getLocation());
        light.turnOn();
    }
}
