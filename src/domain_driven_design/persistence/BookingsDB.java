package domain_driven_design.persistence;

import domain_driven_design.domain.booking_recorder.entities.Booking;

import java.util.*;

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
    public void delete(Integer id) {
        map.remove(id);
    }

    @Override
    public List<Booking> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Integer largestId() {
        return getAll().isEmpty()
                ? 0
                : Collections.max(getAll().stream().map(Booking::getId).toList());
    }

}
