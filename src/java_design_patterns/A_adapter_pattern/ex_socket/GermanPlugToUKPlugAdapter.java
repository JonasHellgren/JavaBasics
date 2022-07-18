package java_design_patterns.A_adapter_pattern.ex_socket;

public class GermanPlugToUKPlugAdapter implements UKPlug {

    private GermanPlug plug;

    public GermanPlugToUKPlugAdapter(GermanPlug plug) {
        this.plug = plug;
    }

    @Override
    public String provideElectricity() {
       return plug.provideElectricity();
    }

}
