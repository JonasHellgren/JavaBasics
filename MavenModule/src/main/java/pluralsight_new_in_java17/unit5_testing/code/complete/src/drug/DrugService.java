package pluralsight_new_in_java17.unit5_testing.code.complete.src.drug;

import pluralsight_new_in_java17.unit5_testing.code.main.src.drug.database.DrugRecord;
import pluralsight_new_in_java17.unit5_testing.code.main.src.drug.database.DrugSource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DrugService {

    private DrugSource drugSource;

    public DrugService(DrugSource drugSource) {
        this.drugSource = drugSource;
    }

    public List<DispensableDrug> findDrugsStartingWith(String startsWith) {
        if (startsWith == null || startsWith.isBlank()) {
            throw new IllegalArgumentException("Starts with string must be non-null, non-blank, " +
                    "and at least two characters.  String provided: [" + startsWith + "]");
        }
        List<DrugRecord> records = this.drugSource.findDrugsStartingWith(startsWith);
        List<DispensableDrug> matchedDrugs = convertRecords(records);
        matchedDrugs.sort(Comparator.comparing(DispensableDrug::drugName));
        return matchedDrugs;
    }

    private List<DispensableDrug> convertRecords(List<DrugRecord> records) {
        ArrayList<DispensableDrug> dispensableDrugs = new ArrayList<>();
        for (DrugRecord record : records) {
            dispensableDrugs.add(convertRecord(record));
        }
        return dispensableDrugs;
    }

    private DispensableDrug convertRecord(DrugRecord record) {
        List<DrugClassification> classifications = new ArrayList<>();
        for (int code : record.classCodes()) {
            classifications.add(DrugClassification.getClassificationByCode(code));
        }
        return new DispensableDrug(record.drugName(), classifications.toArray(new DrugClassification[0]),
                record.deaSchedule() > 0);
    }

}
