package java_design_patterns.A_adapter_pattern.ex_socket;

public class UKElectricalSocket {

    public String plugIn(UKPlug plug) {
       return plug.provideElectricity();
    }
}