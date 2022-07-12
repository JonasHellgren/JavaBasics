package effective_java.E_generics.item33;

import java.util.EnumMap;
import java.util.Map;

public class User {
        private final Map<UserProperty, Object> properties = new EnumMap<>(UserProperty.class);

        public Object getProperty(UserProperty property)
        {
            return properties.get(property);
        }

        public void setProperty(UserProperty property, Object value)
        {
            properties.put(property, value);
        }
    }