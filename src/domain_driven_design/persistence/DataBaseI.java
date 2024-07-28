package domain_driven_design.persistence;

import java.util.List;

public  interface DataBaseI<T> {

    void create(T rec);
    T read(Integer id);
    void delete(Integer id);
    List<T> getAll();
    Integer largestId();

}
