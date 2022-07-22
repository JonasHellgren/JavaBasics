package java_design_patterns.O_state.mobile;

import lombok.extern.java.Log;

public class Silent implements AlertStateInterface {

    public static final int MAX_SILENT_ALERTS = 3;
    Long counter;

    public Silent() {
        this.counter = 0L;
    }

    @Override
    public void alert(MobilePhone mobilePhone)
    {
        System.out.println("silent...");
        counter++;

        if (counter>= MAX_SILENT_ALERTS) {
            System.out.println("Nof silent alerts exceeded, switching to vibration state, counter = "+counter);
            counter= 0L;
            mobilePhone.setState(new Vibration());
        }

    }
}
