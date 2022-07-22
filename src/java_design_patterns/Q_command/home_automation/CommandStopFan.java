package java_design_patterns.Q_command.home_automation;

public class CommandStopFan implements CommandInterface {
    Fan fan;

    public CommandStopFan(Fan fan) {
        super();
        this.fan = fan;
    }

    public void execute() {
        System.out.println("Starting fan in "+fan.getLocation());
        fan.start();
    }
}
