package java_design_patterns.Q_command.home_automation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Fan {

    String location;

    void start() {
        System.out.println("Fan Started..");
    }

    void stop() {
        System.out.println("Fan stopped..");
    }
}
