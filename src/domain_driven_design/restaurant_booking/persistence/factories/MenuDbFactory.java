package domain_driven_design.restaurant_booking.persistence.factories;

import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;
import domain_driven_design.restaurant_booking.domain.shared.value_obj.Price;
import domain_driven_design.restaurant_booking.persistence.MenuDb;

import java.util.UUID;

public class MenuDbFactory {

    public static MenuDb ofMcD() {

        MenuDb menuDb=MenuDb.empty();

        menuDb.create(Dish.builder().id(1).name("BigMac").price(Price.ofEuro(2)).build());

        return menuDb;
    }

}
