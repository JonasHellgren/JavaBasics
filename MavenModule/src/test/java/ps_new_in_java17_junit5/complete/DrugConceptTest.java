package ps_new_in_java17_junit5.complete;

import org.junit.jupiter.api.Test;
import pluralsight_new_in_java17.unit5_testing.code.complete.src.drug.DispensableDrug;
import pluralsight_new_in_java17.unit5_testing.code.complete.src.drug.DrugClassification;
import pluralsight_new_in_java17.unit5_testing.code.complete.src.drug.DrugConcept;

import static org.junit.jupiter.api.Assertions.*;

class DrugConceptTest {

    private final static DrugConcept TEST_CONCEPT = new DrugConcept(new DrugClassification[]{
            DrugClassification.ANTIANXIETY,
            DrugClassification.ANALGESICS_NARCOTIC,
            DrugClassification.NARCOTIC_ANTHISTAMINE});

    @Test
    void drugBelongsInConceptIfOneClassMatches() {
        DispensableDrug drug = new DispensableDrug("adrug",
                new DrugClassification[] {DrugClassification.ANALGESIC,
                        DrugClassification.ANTIANXIETY}, false);
        assertTrue(TEST_CONCEPT.isDrugInConcept(drug));
    }

    @Test
    void drugNotInConceptIfNoClassesMatch() {
        DispensableDrug drug = new DispensableDrug("adrug",
                new DrugClassification[] {DrugClassification.ANALGESIC,
                        DrugClassification.NASAL_CORTICOSTEROIDS}, false);
        assertFalse(TEST_CONCEPT.isDrugInConcept(drug));
    }
}