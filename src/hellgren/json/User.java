package hellgren.json;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private transient String nationality;   //transient, it's ignored by default and not included in the JSON serialization or deserialization

}
