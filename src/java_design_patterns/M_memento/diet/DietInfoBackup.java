package java_design_patterns.M_memento.diet;

public class DietInfoBackup {

    DietInfo.Memento memento;

    public void saveState(DietInfo dietInfo) {
        memento = dietInfo.save();
    }

    public void restoreState(DietInfo dietInfo) {
        dietInfo.restore(memento);
    }

}
