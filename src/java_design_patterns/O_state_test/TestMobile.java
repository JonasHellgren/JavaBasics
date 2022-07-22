package java_design_patterns.O_state_test;

import java_design_patterns.O_state.mobile.MobilePhone;
import java_design_patterns.O_state.mobile.Silent;
import org.junit.Test;

public class TestMobile {

    @Test
    public void test() {
        MobilePhone stateContext = new MobilePhone();
        stateContext.alert();
        stateContext.setState(new Silent());
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
        stateContext.alert();
    }

}
