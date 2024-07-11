package ddd;

import domain_driven_design.restaurant_booking.domain.bill.Bill;
import domain_driven_design.restaurant_booking.domain.bill.entities.BillItem;
import domain_driven_design.restaurant_booking.domain.booking_recorder.BookingRecorder;
import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.Booking;
import domain_driven_design.restaurant_booking.domain.booking_recorder.entities.PayingGuest;
import domain_driven_design.restaurant_booking.persistence.factories.BookingDbFactory;
import effective_java.F_enums_and_annotaitons.item39.PersonUpperCase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBookingRecorder {

    public static final int N_BOOKINGS_SOME_MCD = 2;
    BookingRecorder bookings;

    @Before
    public void init() {
        bookings = new BookingRecorder(BookingDbFactory.ofSomeMcd());
    }

    @Test
    public void thenCorrectNofBoookings() {
        Assert.assertEquals(N_BOOKINGS_SOME_MCD, bookings.nBookings());
    }

    @Test
    public void whenAddingBooking_thenCorrectNofBoookings() {
        bookings.addBooking(Booking.ofIdAndGuest(3, PayingGuest.ofName("Christofer")));
        Assert.assertEquals(N_BOOKINGS_SOME_MCD + 1, bookings.nBookings());
    }

    @Test
    public void whenNoSetBill_thenEmptyBill() {
        var optBill = bookings.getBooking(1).getBill();
        Assert.assertTrue(optBill.isEmpty());
    }


    @Test
    public void whenSetBill_thenPresentBill() {
        var billEmpty=Bill.empty();
        var bill = billEmpty.withItem(new BillItem(1,1));
        bookings.setBillOfBooking(1, bill);
        var optBill = bookings.getBooking(1).getBill();
        Assert.assertTrue(optBill.isPresent());
    }


}
