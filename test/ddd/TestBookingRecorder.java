package ddd;

import domain_driven_design.domain.bill.Bill;
import domain_driven_design.domain.bill.entities.BillItem;
import domain_driven_design.domain.booking_recorder.BookingRecorder;
import domain_driven_design.domain.booking_recorder.entities.Booking;
import domain_driven_design.domain.booking_recorder.entities.PayingGuest;
import domain_driven_design.persistence.factories.BookingDbFactory;
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
    public void thenCorrectNofBookings() {
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
        Assert.assertEquals(1,optBill.orElseThrow().billItems().get(0).dishId().intValue());
    }

}
