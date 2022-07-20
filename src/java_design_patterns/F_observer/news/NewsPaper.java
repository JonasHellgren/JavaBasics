package java_design_patterns.F_observer.news;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class NewsPaper {
    private String news;

    private final PropertyChangeSupport support;

    public NewsPaper() {
        support = new PropertyChangeSupport(this);
    }

    public void addSubscriber(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removeSubscriber(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setNews(String value) {
        support.firePropertyChange("news", this.news, value);
        this.news = value;
    }

    public int nofSubscribers() {
        return support.getPropertyChangeListeners().length;
    }

}
