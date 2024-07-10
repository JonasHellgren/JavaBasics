package ddd;

import domain_driven_design.restaurant_booking.persistence.factories.BookingDbFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestBookingsDB {

    @Test
    public void whenMcD_thenCorrect() {
        var bdb = BookingDbFactory.ofSomeMcd();
        Assert.assertEquals("Jonas", bdb.read(1).getGuest().name());
    }

    @Test
    public void whenGetAll_thenCorrect() {
        var bdb = BookingDbFactory.ofSomeMcd();
        Assert.assertEquals(2, bdb.getAll().size());
    }
}
