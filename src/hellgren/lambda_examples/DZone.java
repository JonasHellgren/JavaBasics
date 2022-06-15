package hellgren.lambda_examples;


import hellgren.lambda_examples.dzoneclasses.MathFunctions;
import hellgren.lambda_examples.dzoneclasses.VehicleParameters;

public class DZone {


    public static void main(String[] args) {

        VehicleParameters par= VehicleParameters.builder()
                .mass(1000d)
                .CdA(0.5d)
                .build();

        MathFunctions mf=new MathFunctions(par);

        System.out.println("mf = " + mf.getPar());

        System.out.println(mf.squareRoot.findSquareRoot(100));
        System.out.println("MathFunctions.square.apply(5) = " + mf.square.apply(5d));
        System.out.println("MathFunctions.cube.apply(3) = " + mf.cube.apply(3d));
        System.out.println("MathFunctions.force.apply(1d) = " + mf.force.apply(-1d));
        System.out.println("mf.massTimesCda = " + mf.massTimesCda.get());


    }

    private  void test() {

    }

}
