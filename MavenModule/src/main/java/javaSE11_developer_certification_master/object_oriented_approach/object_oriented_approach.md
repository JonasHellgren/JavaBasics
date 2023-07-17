# The Java Object-Oriented Approach

Use abstract classes when you want to 
- Offer some base functionality to subclasses
- Provide a template for future classes
- Create abstract members that are not public

Use interfaces
- Highest level of abstraction
- Highest level of loose coupling
- Implement more interfaces

Polymorphism is very powerful

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

output:

        mass = 95 is Overweight
        mass = 65 is Healthy
        bmi = 22.0 is Healthy