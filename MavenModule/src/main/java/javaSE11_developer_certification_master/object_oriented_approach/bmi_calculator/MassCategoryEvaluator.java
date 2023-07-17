package javaSE11_developer_certification_master.object_oriented_approach.bmi_calculator;

public abstract class MassCategoryEvaluator<T> {

    protected final T  input;

    public MassCategoryEvaluator(T input) {
        this.input = input;
    }

    protected abstract boolean isLimitLargerThanInput(MassCategory massCategory);

    public MassCategory findCategory() {

        for (int i = MassCategory.values().length-1; i >= 0; i--) {
            MassCategory massCategory = MassCategory.values()[i];
            if (isLimitLargerThanInput(massCategory)) {  //sub class defines isLimitLargerThanInput
                return massCategory;
            }
        }
        throw new RuntimeException ("Failed to find Category");
    }

}
