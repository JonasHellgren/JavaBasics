package domain_driven_design.restaurant_booking.persistence;

import java.util.List;
import java.util.UUID;

public  interface DataBase<T> {

    void create(T record);
    T read(Integer id);
    //void delete(UUID id)

    List<T> getAll();
}
