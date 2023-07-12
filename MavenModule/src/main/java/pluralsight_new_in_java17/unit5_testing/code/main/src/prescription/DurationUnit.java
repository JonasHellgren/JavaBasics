package pluralsight_new_in_java17.unit5_testing.code.main.src.prescription;

import java.util.Objects;

public enum DurationUnit {

    DAY("day", "days", 1),
    WEEK("week", "weeks", 7),
    MONTH("month", "months", 30);

    public String singularForm;
    public String pluralForm;
    private int multiplier;

    DurationUnit(String singularForm, String pluralForm, int multiplier) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.multiplier = multiplier;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public static DurationUnit getByTextValue(String durationString) {
        Objects.requireNonNull(durationString, "Duration string must be non-null");
        for (DurationUnit unit : DurationUnit.values()) {
            if ((unit.singularForm.equals(durationString.toLowerCase())) ||
                    (unit.pluralForm.equals(durationString.toLowerCase()))) {
                return unit;
            }
        }
        return null;
    }
}
