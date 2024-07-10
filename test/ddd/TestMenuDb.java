package ddd;

import domain_driven_design.restaurant_booking.persistence.MenuDb;
import domain_driven_design.restaurant_booking.persistence.factories.MenuDbFactory;
import org.junit.Test;

import java.util.UUID;

public class TestMenuDb {


    @Test
   public void whenMcD_thenCorrect() {
        MenuDb menuDb=MenuDbFactory.ofMcD();
        System.out.println("menuDb.read(UUID.fromString(\"1\")) = " + menuDb.read(1));
    }

}
