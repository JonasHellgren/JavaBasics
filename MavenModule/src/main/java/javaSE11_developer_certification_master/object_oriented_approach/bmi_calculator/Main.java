package javaSE11_developer_certification_master.object_oriented_approach.bmi_calculator;

public class Main {

    public static void main(String[] args) {

        MassCategoryEvaluator bmce;    //polymorphism <=> the exact implementation of bmce is TBD
        int mass = 95;
        bmce = new MassCategoryMassBased(mass);
        System.out.println("mass = " + mass + " is " + bmce.findCategory());

        mass = 65;
        bmce = new MassCategoryMassBased(mass);
        System.out.println("mass = " + mass + " is " + bmce.findCategory());

        double bmi = 22;
        bmce = new MassCategoryBmiBased(bmi);
        System.out.println("bmi = " + bmi + " is " + bmce.findCategory());

        bmi = 0;            //shall raise IllegalArgumentException
        bmce = new MassCategoryBmiBased(bmi);
        System.out.println("bmi = " + bmi + " is " + bmce.findCategory());


    }

}
