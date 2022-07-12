package effective_java.E_generics.item29;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {


    public static  <E> List<E> listJoiner(E elem1, E elem2)  {

        List<E> list=new ArrayList<>();
        list.add(elem1);
        list.add(elem2);
        return list;
    }

    public static  <E> void listExtender(List<E> list, E elem) {
        list.add(elem);
    }

}
