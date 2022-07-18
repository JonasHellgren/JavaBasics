package java_design_patterns.A_adapter_pattern_test;

import java_design_patterns.A_adapter_pattern.ex_socket.*;
import org.junit.Assert;
import org.junit.Test;

public class TestSocket {

    public static final String GERMAN_PLUG_MESSAGE = "Providing electricity via german plug";
    public static final String UK_PLUG_MESSAGE = "Providing electricity via UK plug";

    @Test
    //ukSocket - ukPlug
    public void testUkSocketUkPlug() {
        UKElectricalSocket ukSocket = new UKElectricalSocket();
        UKPlug ukPlug = () -> UK_PLUG_MESSAGE;
        System.out.println(ukSocket.plugIn(ukPlug));
        Assert.assertEquals(UK_PLUG_MESSAGE,ukSocket.plugIn(ukPlug));
    }

    @Test
    //germanSocket -  germanPlug
    public void testGermanSocketGermanPlug() {
        GermanPlug germanPlug = () -> GERMAN_PLUG_MESSAGE;
        GermanElectricalSocket germanSocket = new GermanElectricalSocket();
        System.out.println(germanSocket.plugIn(germanPlug));
        Assert.assertEquals(GERMAN_PLUG_MESSAGE,germanSocket.plugIn(germanPlug));
    }

    @Test
    //ukSocket - germanToUkAdapter - germanPlug
    public void testUkSocketGermanToUkAdapterGermanPlug() {
        GermanPlug germanPlug = () -> GERMAN_PLUG_MESSAGE;
        UKElectricalSocket ukSocket = new UKElectricalSocket();
        UKPlug germanToUkAdapter = new GermanPlugToUKPlugAdapter(germanPlug);  //GermanPlugToUKPlugAdapter(GermanPlug plug)
        System.out.println(ukSocket.plugIn(germanToUkAdapter));  //works because GermanPlugToUKPlugAdapter implements UKPlug

        Assert.assertEquals(GERMAN_PLUG_MESSAGE,ukSocket.plugIn(germanToUkAdapter));

    }

    @Test
    //ukSocket -  germanPlug
    public void testUkSocketGermanPlug() {
        GermanPlug germanPlug = () -> GERMAN_PLUG_MESSAGE;
        UKElectricalSocket ukSocket = new UKElectricalSocket();
        //System.out.println(ukSocket.plugIn(germanPlug));  //compilation fails
    }



}
