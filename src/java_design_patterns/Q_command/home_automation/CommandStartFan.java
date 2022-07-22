package java_design_patterns.Q_command.home_automation;

public class CommandStartFan implements CommandInterface {
    Fan fan;

    public CommandStartFan(Fan fan) {
        super();
        this.fan = fan;
    }

    public void execute() {
        System.out.println("Stopping fan in "+fan.getLocation());
        fan.stop();
    }
}
