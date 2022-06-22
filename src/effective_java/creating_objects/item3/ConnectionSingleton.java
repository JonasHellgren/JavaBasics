package effective_java.creating_objects.item3;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Objects;

@AllArgsConstructor
@ToString
public class ConnectionSingleton {
    private final String name;
    private final String url;

    private static ConnectionSingleton connection;

    public static ConnectionSingleton getSingletonInstance(String name, String url) {
        if (Objects.isNull(connection)) {
            connection=new ConnectionSingleton(name,url);
        }
        return connection;
    }

}
