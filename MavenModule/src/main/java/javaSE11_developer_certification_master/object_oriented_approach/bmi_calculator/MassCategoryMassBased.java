package javaSE11_developer_certification_master.object_oriented_approach.bmi_calculator;

public class MassCategoryMassBased extends  MassCategoryEvaluator <Integer> {

    final Integer WHALE_MASS_IN_KG=1000;

    public MassCategoryMassBased(Integer input) {
        super(input);
        if (input> WHALE_MASS_IN_KG || input<=0) {
            throw new IllegalArgumentException("Non possible mass");
        }
    }

    @Override
    protected boolean isLimitLargerThanInput(MassCategory massCategory) {
        return (super.input > MassCategory.massLimit(massCategory));
    }

}
