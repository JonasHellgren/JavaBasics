package ddd;

import domain_driven_design.restaurant_booking.persistence.MenuDb;
import domain_driven_design.restaurant_booking.persistence.factories.MenuDbFactory;
import org.junit.Assert;
import org.junit.Test;

public class TestMenuDb {

    @Test
    public void whenMcD_thenCorrect() {
        MenuDb menuDb = MenuDbFactory.ofMcD();
        Assert.assertEquals("BigMac", menuDb.read(1).getName());
    }

    @Test
    public void whenGetAll_thenCorrect() {
        MenuDb menuDb = MenuDbFactory.ofMcD();
        Assert.assertEquals(6, menuDb.getAll().size());
    }

}
