package javaSE11_developer_certification_master.object_oriented_approach.bmi_calculator;

public class MassCategoryBmiBased extends MassCategoryEvaluator <Double> {

    final Double CRAZY_BMI=100d;

    public MassCategoryBmiBased(Double input) {
        super(input);
        if (input> CRAZY_BMI || input<=0) {
            throw new IllegalArgumentException("Non possible BMI");
        }
    }

    @Override
    protected boolean isLimitLargerThanInput(MassCategory massCategory) {
        return (super.input > MassCategory.bmiLimit(massCategory));
    }
}