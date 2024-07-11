package domain_driven_design.domain.booking_recorder;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.booking_recorder.entities.Booking;
import domain_driven_design.persistence.BookingsDB;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class BookingRecorder {
    BookingsDB bookingsDb;

    public void addBooking(Booking booking) {
        this.bookingsDb.create(booking);
    }

    public void setBillOfBooking(Integer id, Bill bill) {
        bookingsDb.read(id).setBill(bill);
    }

    public List<Integer> getBookingIds() {
        return bookingsDb.getAll().stream().map(Booking::getId).toList();
    }

    boolean isPresent(Integer id) {
        return getBookingIds().contains(id);
    }

    public Booking getBooking(Integer id) {
        return bookingsDb.read(id);
    }

    public void deleteBooking(Integer id) {
        bookingsDb.delete(id);
    }

    public int nBookings() {
        return getBookingIds().size();
    }

    public Integer largestId() {
        return bookingsDb.largestId();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bookings:").append(System.lineSeparator());
        getBookingIds().forEach(
                id -> sb.append(getBooking(id).toString()).append(System.lineSeparator()));
        return sb.toString();
    }

}
