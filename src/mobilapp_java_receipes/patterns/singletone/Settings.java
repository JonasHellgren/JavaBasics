package mobilapp_java_receipes.patterns.singletone;

import lombok.ToString;

@ToString
public class Settings {
    //Singleton
    static Settings instance;

    private Settings() {
    }

    public int port;
    public String host;

    static Settings getInstance() {
        if (instance == null) {
            instance = new Settings();
        }
        return instance;
    }


}
