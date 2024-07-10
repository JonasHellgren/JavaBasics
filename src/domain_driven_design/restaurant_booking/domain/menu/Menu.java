package domain_driven_design.restaurant_booking.domain.menu;

import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;
import domain_driven_design.restaurant_booking.persistence.MenuDb;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
public class Menu {
    List<Integer> dishes;
    MenuDb menuDb;

    public void addDish(Dish dish) {
        this.dishes.add(dish.getId());
        this.menuDb.create(dish);
    }

    public List<Integer> getDishIds() {
    return dishes;
    }

    public Dish getDish(Integer id) {
        return menuDb.read(id);
    }

}
