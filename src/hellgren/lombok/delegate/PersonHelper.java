package hellgren.lombok.delegate;

public class PersonHelper {

    public  boolean isAgeOk(Person person) {
        return person.getAge()>=0;
    }



    public  boolean isAdult(Person person) {
        return person.getAge()>=18;
    }

}
