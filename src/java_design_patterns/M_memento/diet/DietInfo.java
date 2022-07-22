package java_design_patterns.M_memento.diet;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter
public class DietInfo {

    String personName;
    int dayNumber;
    int weight;

    // memento - object that stores a backup of the present state
    @AllArgsConstructor
    class Memento {
        String mementoPersonName;
        int mementoDayNumber;
        int mementoWeight;
    }

    public void setDayNumberAndWeight(int dayNumber, int weight) {
        this.dayNumber = dayNumber;
        this.weight = weight;
        System.out.println(this);
    }

    public Memento save() {
        return new Memento(personName, dayNumber, weight);
    }

    public void restore(Object objMemento) {
        Memento memento = (Memento) objMemento;
        personName = memento.mementoPersonName;
        setDayNumberAndWeight(memento.mementoDayNumber,memento.mementoWeight);
    }

}
