package domain_driven_design.restaurant_booking.persistence.factories;

import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.Booking;
import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.PayingGuest;
import domain_driven_design.restaurant_booking.persistence.BookingsDB;

public class BookingDbFactory {

    private BookingDbFactory() {
    }

    public static BookingsDB ofSomeMcd() {
        BookingsDB bdb=BookingsDB.empty();
        bdb.create(Booking.ofIdAndGuest(1, PayingGuest.ofName("Jonas")));
        bdb.create(Booking.ofIdAndGuest(2, PayingGuest.ofName("Katja")));
        return bdb;
    }
}
