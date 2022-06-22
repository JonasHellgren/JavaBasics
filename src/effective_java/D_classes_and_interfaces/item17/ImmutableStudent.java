package effective_java.D_classes_and_interfaces.item17;

import lombok.Getter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * The class must be declared as final so that child classes can’t be created.
 * Data members in the class must be declared private so that direct access is not allowed.
 * Data members in the class must be declared as final so that we can’t change the value of it after object creation.
 * A parameterized constructor should initialize all the fields performing a deep copy so that data members can’t be modified with an object reference.
 * Deep Copy of objects should be performed in the getter methods to return a copy rather than returning the actual object reference)
 */

@ToString
public final  class ImmutableStudent {

    private final String name;
    private final int regNo;
    private final Map<String, String> metadata;

    public ImmutableStudent(String name, int regNo, Map<String, String> metadata)
    {
        this.name = name;
        this.regNo = regNo;

        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :  metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }

        this.metadata = tempMap;
    }

    public String getName() { return name; }

    public int getRegNo() { return regNo; }

    public Map<String, String> getMetadata()
    {

        Map<String, String> tempMap = new HashMap<>();
        for (Map.Entry<String, String> entry :
                this.metadata.entrySet()) {
            tempMap.put(entry.getKey(), entry.getValue());
        }
        return tempMap;
    }
}