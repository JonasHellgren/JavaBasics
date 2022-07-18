package java_design_patterns.A_adapter_pattern.ex_socket;

public class GermanElectricalSocket {

    public String plugIn(GermanPlug plug) {
        return plug.provideElectricity();
    }
}