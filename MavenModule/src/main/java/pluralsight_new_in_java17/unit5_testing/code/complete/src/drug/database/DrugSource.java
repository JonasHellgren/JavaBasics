package pluralsight_new_in_java17.unit5_testing.code.complete.src.drug.database;

import java.util.List;

public interface DrugSource {
    List<DrugRecord> findDrugsStartingWith(String startingString);
}
