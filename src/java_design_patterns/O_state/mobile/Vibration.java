package java_design_patterns.O_state.mobile;

public class Vibration implements AlertStateInterface {
    @Override
    public void alert(MobilePhone ctx)
    {
        System.out.println("vibration...");
    }
}
