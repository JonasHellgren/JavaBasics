package mobilapp_java_receipes.patterns.facade;

import org.junit.Test;

public class TestKitchen {

    // Complex parts
    static class Kettle {
        void turnOff() {
            System.out.println("Kettle turn off");
        }
    }

    static class Toaster {
        void turnOff() {
            System.out.println("Toaster turn off");
        }
    }

    static class Refrigerator {
        void turnOff() {
            System.out.println("Refrigerator turn off");
        }
    }

    //Facade
    static class Kitchen {
        Kettle kettle;
        Toaster toaster;
        Refrigerator refrigerator;

        public Kitchen(Kettle kettle, Toaster toaster,
                       Refrigerator refrigerator) {
            this.kettle = kettle;
            this.toaster = toaster;
            this.refrigerator = refrigerator;
        }

        void off() {
            kettle.turnOff();
            toaster.turnOff();
            refrigerator.turnOff();
        }
    }

    @Test
    public void whenOff() {
        var kettle = new Kettle();
        var toaster = new Toaster();
        var refrigerator = new Refrigerator();
        var kitchen = new Kitchen(
                kettle, toaster, refrigerator);
        kitchen.off();


    }

}
