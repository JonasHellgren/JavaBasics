package java_design_patterns.O_state.mobile;

public class MobilePhone
{
    private AlertStateInterface currentState;

    public MobilePhone()
    {
        currentState = new Vibration();
    }

    public void setState(AlertStateInterface state)
    {
        currentState = state;
    }

    public void alert()
    {
        currentState.alert(this);
    }
}
