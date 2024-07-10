package domain_driven_design.restaurant_booking.domain.booking_recorder;

import domain_driven_design.restaurant_booking.domain.bill.Bill;
import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.Booking;
import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;
import domain_driven_design.restaurant_booking.persistence.BookingsDB;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BookingRecorder {
    BookingsDB bookingsDb;

    public  void addBooking(Booking booking) {
        this.bookingsDb.create(booking);
    }
    public void setBillOfBooking(Integer id, Bill bill) {
        bookingsDb.read(id).setBill(bill);
    }
    public List<Integer> getBookingIds() {
        return bookingsDb.getAll().stream().map(Booking::getId).toList();
    }
    public Booking getBooking(Integer id) {
        return bookingsDb.read(id);
    }

}
