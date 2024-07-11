package domain_driven_design.persistence;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public  interface DataBase<T> {

    void create(T record);
    T read(Integer id);
    void delete(Integer id);
    List<T> getAll();
    Integer largestId();

}
