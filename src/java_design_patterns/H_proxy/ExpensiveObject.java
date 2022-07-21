package java_design_patterns.H_proxy;

import lombok.extern.java.Log;

@Log
public class ExpensiveObject implements ExpensiveObjectInterface {

    public ExpensiveObject() {
        heavyInitialConfiguration();
    }

    @Override
    public void process() {
        log.info("processing complete.");
    }

    private void heavyInitialConfiguration() {
        log.info("Loading initial configuration...");
    }
}
