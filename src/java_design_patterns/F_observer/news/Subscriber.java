package java_design_patterns.F_observer.news;

import lombok.Getter;
import lombok.Setter;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

@Getter
@Setter
public class Subscriber implements PropertyChangeListener {

    private final String name;
    private String news;

    public Subscriber(String name) {
        this.name=name;
    }

    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(name+":news = " + evt.getNewValue());
        this.setNews((String) evt.getNewValue());
    }

}
