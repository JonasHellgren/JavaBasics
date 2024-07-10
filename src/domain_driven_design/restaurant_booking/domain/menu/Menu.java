package domain_driven_design.restaurant_booking.domain.menu;

import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;
import domain_driven_design.restaurant_booking.persistence.MenuDb;
import java.util.List;

public class Menu {
    List<Integer> dishes;
    MenuDb menuDb;

    public Menu(MenuDb menuDb) {
        this.dishes=menuDb.getAll().stream().map(Dish::getId).toList();
        this.menuDb = menuDb;
    }

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

    public int size() {
        return dishes.size();
    }

}
