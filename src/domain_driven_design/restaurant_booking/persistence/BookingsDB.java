package domain_driven_design.restaurant_booking.persistence;

import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.Booking;
import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingsDB  implements DataBase<Booking> {

    Map<Integer,Booking> map;

    public BookingsDB() {
        this.map = new HashMap<>();
    }

    public static BookingsDB empty() {
        return new BookingsDB();
    }

    @Override
    public void create(Booking booking) {
        this.map.put(booking.getId(),booking);
    }

    @Override
    public Booking read(Integer id) {
        return map.get(id);
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(map.values());
    }
}
