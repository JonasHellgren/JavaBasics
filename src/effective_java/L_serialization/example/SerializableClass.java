package effective_java.L_serialization.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
public class SerializableClass implements Serializable {

    public int a;
    public String b;


}
